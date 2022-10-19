package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 实现TCP的网络编程：
 * 例题3：从客户端发送文件给服务器，服务端保存到本地。并返回"发送成功"给客户端
 * 并关闭相应操作
 * @author lzx
 * @create 2022-04-2022/4/28 19:10
 */
public class TCPTest3 {
    /*
     * 这里涉及到的异常应该使用try-catch-finally
     * */
    @Test
    public void client() throws IOException {
        //1.造Socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.获取输出流，输出的内容为从内存中读入的数据
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("敏.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //客户端关闭数据输出
        socket.shutdownOutput();
        //客户端接收来自于服务器端的数据，并显示到控制台上

        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len = is.read(buffer)) != -1){
            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());

        //4.资源关闭
        fis.close();
        os.close();
        socket.close();
        is.close();
        baos.close();

    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("陈敏2.jpg"));

        byte[] buffer =  new byte[1024];
        int len;
        while ((len =is.read(buffer) ) != -1){
            fos.write(buffer,0,len);

        }
        System.out.println("图片传输完成");
        //服务器端给客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，照片获取成功！".getBytes());


        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }
}
