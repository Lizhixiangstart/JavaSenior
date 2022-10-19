package com.atguigu.java;

/**
 * @author lzx
 * @create 2022-05-2022/5/30 17:25
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void methodAbstract() {
        System.out.println("实现类重写了接口中的默认方法");
    }

    @Override
    public void methodDefault() {
        MyInterface.super.methodDefault();
    }

    public static void main(String[] args) {
        //接口中的静态方法只能由接口自己调用
        MyInterface.methodStatic();
        //接口的实现类不能调用接口的静态方法
        //MyInterfaceImpl.methodStatic();
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.methodDefault();

        //私有方法不能在接口外部调用
      // impl.methodPrivate();
    }
}
