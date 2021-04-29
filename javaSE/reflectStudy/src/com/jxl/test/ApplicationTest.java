package com.jxl.test;

import com.jxl.Dao.BaseDaoImp;
import com.jxl.entity.Employee;
import com.jxl.entity.Person;
import com.jxl.util.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @ClassName : ApplicationTest
 * @Author : ljx
 * @Date: 2021/4/26 15:52
 * @Description : 测试使用
 */
public class ApplicationTest {

    public static void main(String[] args) throws ClassNotFoundException {
//        Connection connection = DBUtil.getConnection();
//        System.out.println(connection);

        BaseDaoImp daoImp = new BaseDaoImp();
//        Set nameSet = daoImp.getNameSet(Employee.class);
//
//        for(Iterator it = nameSet.iterator(); it.hasNext();){
//            String emp = (String) it.next();
//            System.out.println(emp);
//        }

        List rows = daoImp.getRows("select * from employees where employee_id=?", new Object[]{206}, Employee.class);

        for(Iterator it = rows.iterator(); it.hasNext();){
            Employee emp = (Employee) it.next();
            System.out.println(emp);
       }


        int j =daoImp.saveObjectIntoDB("insert into testtable (name,age) values(?,?)",new Person("ss",13),Person.class);
        int i = daoImp.saveObjectIntoDB("insert into employees (employee_id,first_name,last_name) values(?,?,?)",
                new Employee(10000,"test","test"),Employee.class);

        System.out.println(j);
        System.out.println(i);
    }

    @Test
    public void test01() throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into testtable(name,age) values(?,?)";
        String names = sql.split("\\(")[1].split("\\)")[0];
        String[] splits = names.split(String.valueOf(','));
        System.out.println(Arrays.toString(splits));


        int i = sql.indexOf("(");
        int j = sql.indexOf(")");
        System.out.println(i);
        System.out.println(j);
        System.out.println(sql.substring(i+1,j));
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        preparedStatement.setObject(1,"lisi");
//        preparedStatement.setObject(2,22);
//        int resultSet = preparedStatement.executeUpdate();
//
//
//        System.out.println(resultSet);


    }
}
