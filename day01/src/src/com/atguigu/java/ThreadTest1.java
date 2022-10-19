package src.com.atguigu.java;

/**
 *
 * 创建多线程的方式二：实现Runable接口
 * 1.创建一个实现了Runable接口的类
 * 2.实现类去实现Runable接口中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Yhread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 * 比较创建线程的两种方式：
 *开发中：优先选择：实现Runable接口的方式
 * 原因：1，实现的方式没有类的单继承的局限性
 *      2.实现的方式更适合处理多个线程有共享数据的情况
 *
 * 联系：public class Thread implements Runable
 * 相同点：两种方式都需要重写run()，将线程的逻辑声明在run()中
 *
 *
 *
 * @author lzx
 * @create 2021-12-2021/12/10 20:12
 */

class MThread implements Runnable{
//2.实现类去实现Runable接口中的抽象方法：run()
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
//        创建实现类的对象
        MThread mThread = new MThread();
//        4.将此对象作为参数传递到Yhread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
//        5.通过Thread类的对象调用start()：①启动线程②调用当前线程的run()-->调用了Runable类型的target的run()
        t1.start();
        //再启动一个线程，遍历100以内的偶数
        Thread t2= new Thread(mThread);
        t2.start();
    }
}
