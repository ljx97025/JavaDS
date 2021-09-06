package com.jxl.iteratorStudy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName : IteratorForCollection
 * @Author : ljx
 * @Date: 2021/5/6 15:57
 * @Description : iterator 学习
 */
public class IteratorForCollection {

    @Test
    public void test01(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        for(int i=0; i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println("--------------------------");
        Iterator iterator = arrayList.iterator();
        /**
         * ArrayList 实现了iterator ，hasNext()只是判断当前cursor是否可以从ArrayList种取值，
         * 取值操作是next()
         */
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("--------------------------");
        arrayList.forEach(System.out::println);

    }
    @Test
    public void test02(){
        People<Apple> p1 = new People<>();
        p1.eatFruit(new Apple());

        People<Banana> p2 = new People<>();
        p2.eatFruit(new Banana());



    }
}


abstract class Fruit {
    public abstract void eat();
}
class Apple extends Fruit {
    @Override
    public void eat() {
        System.out.println("我是苹果，我是酸酸甜甜的");
    }
}

class Banana extends Fruit {
    @Override
    public void eat() {
        System.out.println("我是香蕉，我是软软的");
    }
}

/**
 * 吃瓜群众
 */
class People<T extends  Fruit> {

    public void eatFruit(T t){
        t.eat();
    }
}

