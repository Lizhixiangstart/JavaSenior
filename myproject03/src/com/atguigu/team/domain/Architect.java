package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

/**
*@Description
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月1日 下午5:44:06
*类说明
*
*
*/
public class Architect extends Designer {
	private int stock;//股票

	public Architect() {
		super();
	}



	public Architect(int id, String name, int age, double salary, Equipement equipement, double bonus, int stock) {
		super(id, name, age, salary, equipement, bonus);
		this.stock = stock;
	}



	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return getDetails() + "\t架构师\t" + getStatus() +"\t"+getBonus()+"\t\t"+"\t" + stock + getEquipement().getDescription();
	}
	
	public String getDetailsForTeam() {
		
		return getMemberId() +"/"+getId() +"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t架构师"+getBonus()+"\t"+getStock();
	}
}
