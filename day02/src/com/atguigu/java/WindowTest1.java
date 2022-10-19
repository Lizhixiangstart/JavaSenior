package com.atguigu.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用继承Runable接口的方式
 * 存在线程的安全问题，待解决
 *
 * 1.问题：买票过程中，出现了重票、错票-->出现了线程的安全问题
 * 2.出现问题的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当线程a在操作tickets的时候，其他线程不能参与进来，
 * 直到线程a操作完tickets之后其他线程才能参与进来。这种情况即使线程a出现呢了阻塞情况，也不能被改变
 * 4.在Java中，我们通过同步机制，来解决线程的安全问题
 *
 *  方式一：同步代码块
 *  synchronized(同步监视器){
 *      //需要被同步的代码
 *  }
 *  说明:1.操作共享数据的代码即为需要被同步的代码    -->不能包含代码多了，也不能包含代码少了
 *      2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 *      3.同步监视器。俗称：锁。任何类的一个对象都可以充当锁。
 *          要求：多个线程必须要共用同一把锁。
 *      补充：在实现Runable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *
 *  方式二：同步方法
 *      如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的
 *
 *
 * 5.同步的方式：解决了线程的安全问腿。---好处
 *  操作同步代码时，只能由一个线程参与，其他线程等待。相当于是一个单线程的线程
 * 2.
 * @author lzx
 * @create 2021-12-2021/12/11 12:09
 */
class Window1 implements Runnable{

     Object  obj = new Object();
private int tickets =100;
    @Override
    public void run() {
       while (true){
        synchronized (obj){
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "买票，票号为" + tickets);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                tickets--;

            }else{
                break;
            }
         }
       }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1:");
        t2.setName("窗口2:");
        t3.setName("窗口3:");

        t1.start();
        t2.start();
        t3.start();
    }
}



