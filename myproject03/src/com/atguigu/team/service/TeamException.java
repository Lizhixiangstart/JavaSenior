package com.atguigu.team.service;
/**
*@Description 自定义异常类
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月4日 下午2:06:26
*类说明
*
*
*/
public class TeamException extends Exception {
	static final long serialVersionUID = -3387516993124229948L;

	public TeamException() {
		
	}
	
	public TeamException(String msg) {
		super(msg);
		
	}
}