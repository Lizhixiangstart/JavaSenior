package com.atguigu.team.domain;
/**
*@Description
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月1日 下午4:56:06
*类说明
*
*
*/
public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public String getDetails() {
		return id+"\t"+"name"+"\t"+age+"\t"+salary;
	}
	
	@Override
		public String toString() {
			return getDetails();
		}
	
}
