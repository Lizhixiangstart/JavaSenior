package com.atguigu.java2;

/**
 * 线程通信的例子：使用两个线程打印1-100，线程一，线程二交替打印
 *
 * 涉及到三个方法;
 * wait():一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒权限高的
 * notifyAll():一旦执行此方法，就唤醒所有的线程
 *
 * 说明：
 * 1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或同步方法中
 * 2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *                              否则会出现IllegalMonitorStateException异常
 * 3.wait(),notify(),notifyAll()，三个方法定义在java.lang.Object类中
 *
 * 面试题：sleep()和wait()的区别
 * 1.相同点：一旦执行方法，都可以使得线程进入阻塞状态
 * 2.不同点：1)两个方法声明位置不同：Thread类中声明slee(),object类中调用wait()
 *          2)调用的要求不同：sleep()可以在任何需要的场景下声明下调用。wait()使用在同步监视器中
 *          3)关于是否释放同步监视器：如果两个方法都使用同步代码块或同步方法中wait()会释放同步监视器，sleep()不会释放同步监视器
 * @author lzx
 * @create 2021-12-2021/12/17 16:19
 */

class Number implements Runnable{
    private int number = 1;
    Object obj = new Object();



    @Override
    public void run() {
        while(true){
            synchronized (obj) {
                obj.notify();
                if(number <= 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
public class CommunciationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
