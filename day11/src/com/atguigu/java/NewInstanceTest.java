package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 * @author lzx
 * @create 2022-04-2022/4/30 21:52
 */
public class NewInstanceTest {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {

        Class clazz = Person.class;
        /*newInstacne():调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参的构造器
        要想此方法正常创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2，空参的构造器的访问权限得够。通常，设置为public

        在javabean中要求提供一个public的空参构造器，原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
        */

        Person obj = (Person) clazz.newInstance();


    }
    //体会反射的动态性
    @Test
    public void test2(){
        int num = new Random().nextInt(3);//0,1,2
        String calssPath = "";
        switch (num){
            case 0:
                calssPath = "java.util.Date";
                break;
            case 1:
                calssPath = "java.lang.Oject";
                break;
            case 2:
                calssPath = "com.atguigu.java.Person";
                break;
        }
        try {
            Object obj = getInstance(calssPath);
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
    /*
    此方法创建一个指定类的对象
    classPath：指定类的全类名
    * */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
