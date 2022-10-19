package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地
 *
 * @author lzx
 * @create 2022-04-2022/4/28 18:37
 */
public class TCPTest2 {
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
        socket.shutdownOutput();
        //4.资源关闭
        fis.close();
        os.close();
        socket.close();


    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("陈敏.jpg"));

        byte[] buffer =  new byte[1024];
        int len;
        while ((len =is.read(buffer) ) != -1){
            fos.write(buffer,0,len);

        }

        fos.close();
        is.close();
        socket.close();
        ss.close();
    }

}

