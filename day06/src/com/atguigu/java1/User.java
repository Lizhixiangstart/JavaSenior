package com.atguigu.java1;

/**
 * @author lzx
 * @create 2022-03-2022/3/12 22:41
 */
public class User implements Comparable {
    private String name;
    private int age;

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User()");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, int age) {        this.name = name;
        this.age = age;
    }
    //按照姓名从大到小排列，年龄从小到大排列
    @Override
    public int compareTo(Object o) {
       if (o instanceof User){
           User user = (User)o;
//           return this.name.compareTo(user.name);
           int compare = -this.name.compareTo(user.name);
           if (compare != 0){
               return compare;
           }else{
               return Integer.compare(this.age,user.age);
           }
       }else{
           throw new RuntimeException("输入的类型不匹配");
       }
    }
}
