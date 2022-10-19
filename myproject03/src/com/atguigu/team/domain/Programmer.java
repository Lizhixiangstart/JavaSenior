package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

/**
*@Description
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月1日 下午4:59:39
*类说明
*
*
*/
public class Programmer extends Employee {
	
	private int memberId;//开发团队中的id
	private Status status = Status.FREE;
	private Equipement equipement;
	public Programmer() {
		super();
	}
	
	public Programmer(int id, String name, int age, double salary, Equipement equipement) {
		super(id, name, age, salary);
		this.status = status;
		this.equipement = equipement;
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	@Override
	public String toString () {
		return getDetails() + "\t程序员\t"+status+"\t\t\t"+equipement.getDescription();
		
	}
	
	public String getTeamBaseDetails() {
		 return getMemberId() +"/"+getId() +"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员"+"\t";
	}
	public String getDetailsForTeam() {
		return getMemberId() +"/"+getId() +"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员"+"\t";
	}
	
	
	
}