package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三:实现Callable接口，--JDK5.0新增
 *
 *
 * 如何理解实现Callable接口创建多线程比实现Runable接口创建多线程方式强大？
 * 1.call()可以有返回值的
 * 2.call()可以抛出异常
 * 3.call()可以抛出异常，被外面的操作捕获，获取异常信息
 * 4.
 * @author lzx
 * @create 2021-12-2021/12/18 13:10
 */
//1.创建一个实现Callable接口实现类
class NewThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum =0;
        for (int i =1;i<= 100;i++){
            if(i%2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建callabale接口实现类的对象
        NewThread newThread = new NewThread();
        //4.将Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(newThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用构造器
        new Thread(futureTask).start();
        try {
            //6.获取Callable中的call返回值
            //get()返回值即为futureTask构造器参数Callable实现类重写的call()的返回值
            Object sum =futureTask.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
    }
}
