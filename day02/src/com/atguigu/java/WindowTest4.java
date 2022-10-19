package com.atguigu.java;

/**
 * 使用同步方法处理Thread类的方式中的线程安全问题
 *
 * @author lzx
 * @create 2021-12-2021/12/15 6:42
 */
class Window4 extends Thread{
    public static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
       //Class clazz = Window2.class,Window2.class只会加载一次
            //错误方式：this代表着t1，t2，t3三个对象

                //正确的
                //synchronized(obj){}
                //错误的
                //synchronized(this){}
//
                while (true){
                    if (ticket >0){
                        show();
                    }
                    else{
                        break;
                    }
                }




    }

public static synchronized void show(){
        //public synchronized void show(){错误
        //非静态方法同步监视器为t1,t2,t3
    if (ticket >0){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"买票，票号为"+ticket);
        ticket--;

    }

    }
}




public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t3.start();
        t2.start();


    }
}

