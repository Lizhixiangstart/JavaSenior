package com.atguigu.team.service;
/**
*@Description 表示员工的状态
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月1日 下午5:08:27
*类说明
*
*
*/
public class Status {
	private final String NAME;
	private Status(String name) {
		this.NAME = name;
	};
	
	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");
	
	public String getNAME() {
		return NAME;
	}
	
	@Override
	public String toString() {
		return NAME;
	}
}






















