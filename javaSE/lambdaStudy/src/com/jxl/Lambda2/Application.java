package com.jxl.Lambda2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Application
 * @Author : ljx
 * @Date: 2021/4/23 14:56
 * @Description : 运行入口
 */
public class Application {
    public static List<Person> generateList(){
        List<Person> list = new ArrayList();

        list.add(new Person("zhangsan",18,80));
        list.add(new Person("lisi",19,50));
        list.add(new Person("wangwu",13,64));
        list.add(new Person("zhaoliu",15,30));
        list.add(new Person("sunqi",17,65));
        return list;
    }
    public static void main(String[] args){
        List<Person> list = generateList();
        // 使用非lambda方式
        comparePerson(list,new ComparePersonByAgeImp(15));
        comparePerson(list,new ComparePersonByScoreImp(60));

        // 使用lambda方式

        comparePerson(list,(person)->{
            return person.getAge()>15;
        });
        comparePerson(list,(person)->{
            return person.getScore()>60;
        });
    }

    public static void comparePerson(List<Person> list, PersonDao pd){
        List<Person> relist = new ArrayList();
        for(Person p:list){
            if(pd.compare(p)){
                relist.add(p);
            }
        }
//        //需要注意的是像【.】【|】【+】【*】等都是转义字符(正则表达式时)，
//        在作为参数时，需要加入“\\”, 只针对split()
//        System.out.println(pd.getClass().getName());
//        String[] s = pd.getClass().getName().split("\\.");

//        String[] s = pd.getClass().getName().split("\\.");
//        show(relist,s[s.length-1]);

        String name = pd.getClass().getName();
        show(relist,name.substring(name.lastIndexOf(".")+1));
    }

    public static void show(List<Person> list, String desc){
        System.out.println("------------"+desc+" --- result------------");
        for(Person p:list){
            System.out.println(p);
        }

    }

}
