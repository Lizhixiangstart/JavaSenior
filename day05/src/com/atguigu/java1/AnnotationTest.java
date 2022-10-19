package com.atguigu.java1;

/**
 * 注解的使用
 * 1.理解Annotation：
 * ①jdk5.0新增
 * ②Annotation其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，
 * 并执行相应的处理。通过使用Annotation，程序员可以在不改变原有逻辑的情况下，
 * 在源文件中嵌入一些补充信息。代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
 * ③在JavaSE中，注解的使用目的比较简单，例如标记果实的功能，忽略警告等。
 * 在Java EE/Android中注解占据了更重要的角色，例如用来配置引用程序的任何切面，代替javaEE旧版中遗留的繁冗
 * 代码和XML配置等。
 *
 * 2.Annotation使用示例：
 * 示例一：生成文档相关的注解
 * 示例二：在编译是进行格式检查(JDK内置的三个基本注解|)
 * >Override:限定重写父类方法，该注解只能用于方法
 * >Deprecated:用于表示所修饰的元素(类、方法等)已过时。通常是因为
 * 所修饰的结构危险或存在更好的选择
 * >SuppressWarning：抑制编译器警告
 *示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解：参照SuppressWarning定义
 *  >注解声明为@interface
 *  >内部定义成员，通常使用value表示
 *  >可以指定成员的默认值，使用default定义
 *  >如果自定义注解没有成员，表明是一个标识作用
 *  如果注解有成员，在使用注解时，需要指明成员的值
 *  自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 * 自定义注解通常都会指明两个元注解：Retention、Target
 *
 * 4.jdk提供的4中元注解
 * 元注解：对现有的注解进行解释说明的注解
 * Retention：指定所修饰的Annotation的生命周期：SOURCE\CLASS(默认行为)RUNTIME
 *      只有声明为RUNTIME生命周期的注解，才能通过反射获取
 * Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
 * ****************出现的频率较低*********************
 * Doucmented：表示所修饰的注解在被javadoc解析时，保留下来
 * Inherited：被它修饰的Annotation将具有继承性
 *
 * 5.通过反射来获取注解信息---到反射内容再系统讲解
 *
 * 6.jdk8.0新特性：可重复注解，类型注解
 *
 * 6.1可重复注解：①在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *              ②MyAnnotation的Target和Retention和MyAnnotation相同
 * 6.2类型注解：
 * ElementType.TYPE_PARAMETER   表示该注解能写在类型变量的声明前面
 * ElementType.TYPE_USE     表示该注解能写在使用类型的任何语句中
 *
 * @author lzx
 * @create 2022-03-2022/3/2 22:21
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.walk();
    }
}
@MyAnnotation(value = "hello")
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age){
        this.name=name;
        this.age=age;

    }
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}
interface Info{
     void show();


}
class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}