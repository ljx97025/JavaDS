package com.jxl.Dao;

import com.jxl.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

/**
 * @ClassName : BaseDaoImp
 * @Author : ljx
 * @Date: 2021/4/26 19:58
 * @Description :
 */

/*
 * 要查询N张表的数据，但是不想写N多的方法，能否写一个方法完成所有表的查询工作
 *
 * */
public class BaseDaoImp {
    /**
     * 统一的查询表的方法
     * @param sql       不同的sql语句
     * @param params    sql语句的参数
     * @param clazz        sql语句查询返回的对象
     * @return
     */
    public List getRows(String sql,Object[] params,Class clazz){
        List list = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            //建立连接
            connection = DBUtil.getConnection();
            //创建pstmt对象
            pstmt = connection.prepareStatement(sql);
            //给sql语句填充参数
            if(params!=null){
                for(int i = 0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }
            //开始执行查询操作,resultset中有返回的结果，需要讲返回的结果放置到不同的对象中
            resultSet = pstmt.executeQuery();
            //获取结果集合的元数据对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //判断查询到的每一行记录中包含多少个列
            int columnCount = metaData.getColumnCount();



            //循环遍历resultset
            while(resultSet.next()){
                //创建放置具体结果属性的对象
                Object obj = clazz.newInstance();
                for(int i= 0;i<columnCount;i++){
                    //从结果集合中获取单一列的值
                    Object objValue = resultSet.getObject(i+1);
                    //获取列的名称
                    String columnName = metaData.getColumnName(i+1).toLowerCase();
                    //获取类中的属性
                    Field declaredField = null;
                    Method method = null;
                    try {
                        declaredField = clazz.getDeclaredField(columnName);
                        //获取类中属性对应的set方法
                        method = clazz.getMethod(getSetName(columnName),declaredField.getType());
                    } catch (NoSuchFieldException e) {
                        // 如果没有属性则跳过
                        continue;
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        continue;
                    }


                    // 判断是否查询属性与类属性相同
                    if(objValue instanceof Number){
                        Number number = (Number) objValue;
                        String fname = declaredField.getType().getName();
                        if("int".equals(fname)||"java.lang.Integer".equals(fname)){
                            method.invoke(obj,number.intValue());
                        }else if("byte".equals(fname)||"java.lang.Byte".equals(fname)){
                            method.invoke(obj,number.byteValue());
                        }else if("short".equals(fname)||"java.lang.Short".equals(fname)){
                            method.invoke(obj,number.shortValue());
                        }else if("long".equals(fname)||"java.lang.Long".equals(fname)){
                            method.invoke(obj,number.longValue());
                        }else if("float".equals(fname)||"java.lang.Float".equals(fname)){
                            method.invoke(obj,number.floatValue());
                        }else if("double".equals(fname)||"java.lang.Double".equals(fname)){
                            method.invoke(obj,number.doubleValue());
                        }
                    }else{
                        method.invoke(obj,objValue);
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,pstmt,resultSet);
        }

        return list;
    }

    /**
     * 统一保存数据至表的方法 针对 给出具体表的列的sql语句
     * INSERT INTO table_name (column1,column2,column3,...)
     * VALUES (value1,value2,value3,...);
     * @param sql     不同的sql语句
     * @param param  sql语句的参数
     * @param clazz   sql语句保存的对象
     */
    public int saveObjectIntoDB(String sql, Object param, Class clazz){
        Connection connection = null;
        PreparedStatement pstmt = null;
        int result=0;
        try {
            connection = DBUtil.getConnection();
            pstmt = connection.prepareStatement(sql);

//            String[] fieldNames = sql.split("\\(")[1].split("\\)")[0].split(",");
            // 获取列名，从对应的对象中提取内容
            String[] fieldNames = sql.substring(sql.indexOf("(") + 1, sql.indexOf(")")).split("\\,");

            for(int i=0; i<fieldNames.length;i++){
                
                Field declaredField = clazz.getDeclaredField(fieldNames[i]);
                declaredField.setAccessible(true); //设置可见
                Object o = declaredField.get(param);
                pstmt.setObject(i+1,o);
            }
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection,pstmt);
        }
        return result;
    }

    public String getSetName(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }

    public Map getFieldNameMap(Class clazz){
        Field[] declaredFields = clazz.getDeclaredFields();

        HashMap<String, String> fieldNameHashMap = new HashMap();

        for(Field f :declaredFields){
            fieldNameHashMap.put(f.getName(),f.getName());
        }
        return fieldNameHashMap;
    }


}
