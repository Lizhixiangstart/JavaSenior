package src.com.atguigu.java;

/**
 * 测试Thread中的常用方法;
 * 1.start():启动当前线程，调用当前线程的run()
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程执行的操作声明再此方法在中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 *6.yield():释放当cpu的执行权
 * 7.join():在线程A中调用线程B的join(),此时线程A进入阻塞状态，直到线程B完全执行完以后，线程A才结束阻塞状态
 * 8.stop():已过时，当执行此方法时，强制结束当前线程
 * 9.sleep(long millitime):让当前线程"睡眠"指定的millitime毫秒，在millitime时间内，当前线程时阻塞状态
 * 10.isAlive():判断当前线程是否还存活
 *
 * 线程的优先级:
 * 1.
 * MAX_PRIVORITY:10
 * MIN_PRIVORITY:1
 * NORM_PRIVORITY:5   -->默认优先级
 * 2.如何设置线程的优先级：
 *    getPrivority():获取线程的优先级
 *    setPrivority(int p):设置线程的优先级
 *
 * 说明：高优先级的线程要抢占低优先级线程的cpu执行权，但只是从概率上讲，高优先级的线程高概率的情况下先执行。
 * 并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 *
 * @author lzx
 * @create 2021-12-2021/12/8 16:11
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for(int i =0;i<100;i++){
            if(i%2 == 0){
//
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+i);
            }
//            if(i%20 == 0){
//                this.yield();
//            }
        }
    }
    public HelloThread(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread:1");
//        h1.setName("线程一");
        //设置分线程的优先级：
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i =0;i<100;i++){
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+i);
            }
            if(i==20){
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(h1.isAlive());
    }
}
