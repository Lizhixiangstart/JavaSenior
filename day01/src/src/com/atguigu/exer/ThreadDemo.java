package src.com.atguigu.exer;

/**
 * 练习：创建两个分线程，其中一个遍历100以内的偶数，另一个遍历奇数
 * @author lzx
 * @create 2021-12-2021/12/8 15:58
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1();
        MyThread2 m2 = new MyThread2();
        m1.start();
        m2.start();
        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {

                    for(int i=0;i<100;i++){
                        if(i%2 != 0) {
                            System.out.println(Thread.currentThread().getName()+i);
                        }
                    }
                }

        }.start();

        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2 == 0) {
                        System.out.println(Thread.currentThread().getName()+i);
                    }
                }
            }
        }.start();
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2 != 0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2 == 0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}