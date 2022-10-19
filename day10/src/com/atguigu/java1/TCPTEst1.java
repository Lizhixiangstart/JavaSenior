package com.atguigu.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
/*
* 例子1：客户端发送一句话给服务端，服务端将这句话在控制台输出
        * @author lzx
        * @create 2022-04-2022/4/27 23:35
        */
public class TCPTEst1 {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
//1.创建Socket对象，指明服务器端的IP和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,5555);
//2.获取输出流
            os = socket.getOutputStream();
//3.写出数据
            os.write("你好，我是客户端mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
//4.资源的关闭
        } finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
    //服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
//1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(5555);
//2.调用accept(),表示接收来自客户端的Socket
            socket = ss.accept();
//3.获取输入流
            is = socket.getInputStream();
//不建议这样写，可能会出现乱码
// byte[] buffer = new byte[1024];
// int len;
// while ((len = is.read(buffer)) != -1){
// String str = new String(buffer,0,len);
// System.out.print(str);
// }
//4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            System.out.println("收到了来自于："+socket.getInetAddress().getHostAddress()+baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//关闭资源
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (is != null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(socket != null){
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (ss != null){
                            try {
                                ss.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }



    }
}