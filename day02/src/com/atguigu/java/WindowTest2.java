package com.atguigu.java;

/**
 * @author lzx
 * @create 2021-12-2021/12/13 22:43
 */

/**
 *使用同步代码块解决继承Thread类的线程安全问题
 * 例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 *说明：在继承Thread类创建多线程的方式中，慎用this来充当同步监视器
 *
 * @author lzx
 * @create 2021-12-2021/12/10 19:58
 */

class Window2 extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {

            //错误方式：this代表着t1，t2，t3三个对象
            while(true){
                synchronized (obj){
                //Class clazz = Window2.class,Window2.class只会加载一次
                //正确的
                //synchronized(obj){}
                //错误的
                //synchronized(this){}

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(ticket > 0){
                    System.out.println(getName()+":买票，票号为："+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }


    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三：");

        t2.setPriority(10);

        t1.start();
        t2.start();
        t3.start();
    }
}

