package com.atguigu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中有两个主要的问题：
 * 1.如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 2.找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型(应用层、传输层、网络层、物理+数据链路层)
 *
 * 三、通信要素一：IP和端口号
 *
 * 1.IP：唯一的标识 Internet上的计算机(通信实体)
 * 2.在Java中使用InetAddress类代表IP
 * 3.IP分类：IPV4和IPV6；万维网和局域网
 *
 * 4.域名：       www.baidu.com    www.mi.com  www.sina.com    www.jd.com
 *              www.vip.com
 * 5.本地回路地址;127.0.0.1   对应者：localhost
 *
 * 6.如何实例化InetAddress：两个方法：getByName(String host)\get LocalHost()
 *      两个常用方法：getHostName()/getHostAddress()
 * 7.端口号：正在计算机上运行的程序
 *  要求：不用的进程应该有不同的端接号
 *  范围：被规定为一个16位的整数0~65535
 * 8.端口号与IP地址的组合得出一个网络套接字：Socket
 * @author lzx
 * @create 2022-04-2022/4/27 20:31
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            //File file = new File("hello.txt");
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //获取本地IP
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName()
            System.out.println(inet2.getHostName());
            //getHOstAddress()
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
