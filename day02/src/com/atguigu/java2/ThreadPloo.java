package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 *
 * 
 * @author lzx
 * @create 2021-12-2021/12/18 14:39
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i=1;i<= 100;i++){
            if(i %2 ==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i=1;i<= 100;i++){
            if(i %2 !=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPloo {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
//        service1.setCorePoolSize();
        //2.执行指定的线程的操作，需要提供实现Runable接口或Callable接口实现类的对象
        service.execute(new NumberThread());
        service.execute(new NumberThread1());//适合使用于Runable
//        service.submit();//适合使用于Callable

        service.shutdown();
    }

}
