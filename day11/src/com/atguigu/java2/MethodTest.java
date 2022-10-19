package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 * @author lzx
 * @create 2022-05-2022/5/1 11:12
 */
public class MethodTest {
    @Test
    public void test1(){
        Class clazz = Person.class;
        //获取当前运行时类机器所有父类中声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明的所有方法,不包含父类中的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }
    }
    /*
    * 权限修饰符，返回值类型，方法名，(参数类型1 形参名1，……)throws XxxException
    * */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            //1.获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos){
                System.out.println(a);
            }
            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t" );

            
            //3.返回值类型
            System.out.print(m.getReturnType().toString()+"\t");
            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");
            //5.形参列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)){
                 for (int i=0;i< parameterTypes.length;i++){
                    if (i== parameterTypes.length-1){
                        System.out.print(parameterTypes[i].getName()+"args_"+i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName()+"args_"+i+",");
                }
            }
            System.out.println(")");

            //6.抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
//            if (!(exceptionTypes == null && exceptionTypes.length ==0)){
//                System.out.print("throws");
//                for (int i=0;i< exceptionTypes.length;i++){
//                    if (i== exceptionTypes.length-1){
//                        System.out.println(exceptionTypes[i].getName());
//                        break;
//                    }
//                    System.out.println(exceptionTypes[i].getName()+",");
//                }
//            }
            if (exceptionTypes.length > 0){
                System.out.print("throws");
                for (int i=0;i< exceptionTypes.length;i++){
                    if (i== exceptionTypes.length-1){
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.println(exceptionTypes[i].getName()+",");
                }
            }

        }


    }
}
