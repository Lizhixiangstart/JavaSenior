package com.atguigu.team.domain;
/**
*@Description
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月1日 下午4:44:35
*类说明
*
*
*/
public class Printer implements Equipement {
	private String name;//机器型号
	private String type;//机器类型
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Printer() {
		super();
	}
	@Override
	public String getDescription() {
		
		return name+"("+type+")";
	}
	
	
}
