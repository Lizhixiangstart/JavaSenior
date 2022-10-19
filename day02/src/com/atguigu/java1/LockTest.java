package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三;Lock锁---JDk5.0新增
 *
 * 1.面试题：synchromized   与   lock的异同？
 * 相同：二者都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码以后自动的释放同步监视器
 *      Lock需要手动的启动同步(lock()),同时结束同步也需要手动实现(unlock())
 *
 * 2.优先使用顺序：
 * Lock→同步代码块→(已经进入了方法体，分配了相应资源)→同步方法(在方法体之外)
 *
 * 面试题:如何解决线程安全问题？  有几种方式？
 * @author lzx
 * @create 2021-12-2021/12/15 14:47
 */
class Window implements Runnable{
    private  int ticket = 100;
    //实例化reentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
          try{
              //2.调用锁定方法lock()
              lock.lock();
              if(ticket > 0){
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName()+"票号为："+ticket);
                  ticket--;
              }else{
                  break;
              }
          }finally{
                //3.调用解锁方法unlock()
              lock.unlock();
          }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3= new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
