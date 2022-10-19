package src.com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzx
 * @create 2022-05-2022/5/27 23:13
 */
public class ListTest {
    private static List<Student> slist = new ArrayList<>();
    public static void main(String[] args) {
        slist.add(new Student(2001, "zhang", 90));
        slist.add(new Student(2004, "wang", 85));
       print();


    }
    static void print() {
        System.out.println("学号"+'\t'+"姓名"+'\t'+"成绩");
        for(int i=0;i<slist.size();i++) {
            System.out.println(slist.get(i).getId()+"\t"+slist.get(i).getName()+'\t'+slist.get(i).getScore());

        }
    }
}
