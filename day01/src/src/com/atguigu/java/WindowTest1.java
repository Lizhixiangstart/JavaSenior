package src.com.atguigu.java;

/**
 * 创建三个窗口卖票，总票数为100张，使用继承Runable接口的方式
 * 存在线程的安全问题，待解决
 *
 * @author lzx
 * @create 2021-12-2021/12/11 12:09
 */
class Window1 implements Runnable{

private int tickets =100;
    @Override
    public void run() {
        while(true){
            synchronized (this){//此时的this：唯一的Window1的对象     //方式二：synchronized
                if (tickets > 0){
                    System.out.println(Thread.currentThread().getName()+":卖票，票号为："+tickets);
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
        Window w = new Window();

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


