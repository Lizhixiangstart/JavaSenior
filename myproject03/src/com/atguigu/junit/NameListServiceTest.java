package com.atguigu.junit;

import org.junit.Test;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;

/**
*@Description 对NameListS  ervice进行测试
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月4日 下午4:53:53
*类说明
*
*
*/
public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i<employees.length;i++) {
		System.out.println(employees[i]);
	}
	
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id =1;
		id = 10;
		try {
			service.getEmployee(id);
		} catch (TeamException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
}
