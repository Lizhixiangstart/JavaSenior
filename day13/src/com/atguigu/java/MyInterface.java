package com.atguigu.java;

/**
 * @author lzx
 * @create 2022-05-2022/5/30 17:18
 */
public interface MyInterface {
    //如下三个方法的权限修饰符都是public
    void methodAbstract();

    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault(){
        System.out.println("我是接口中的默认方法");
    }
    //Java9允许接口中定义私有的方法
    private void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }
}
