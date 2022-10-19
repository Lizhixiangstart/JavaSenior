package com.atguigu.java1;


import org.junit.Test;

import java.util.List;

/**
 * @author lzx
 * @create 2022-03-2022/3/19 15:22
 */
class DAOTest {
    @Test
    public void test1(){
    CustomerDAO dao1 =  new CustomerDAO();
    dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
        Student student = dao2.getIndex(1);
    }
}