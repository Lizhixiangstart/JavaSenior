package com.atguigu.team.service;
import java.util.jar.Attributes.Name;
import static com.atguigu.team.service.Data.*;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipement;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

/**
*@Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
*@author lzx Email：1181776037@qq.com
*@version 1.0 创作时间：2021年12月1日 下午5:49:57
*类说明
*
*
*/
public class NameListService {
	private static final Equipement equipement = null;
	private Employee [] employees;
	/**
	 * 给employees及数组元素进行初始化
	 */
	public NameListService() {
//		1.根据项目提供的Data类构建相应大小的employee数组
//		2.再根据Data类中的数据后见不同的对象，包括Employee、Programmer、Designer和Architect
//		3.将对象存于数组中
		employees = new Employee[Data.EMPLOYEES.length];
		for(int i=0;i<employees.length;i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			
			//获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][0]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipement equipement ;
			double bonus;
			int stock;
			switch(type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				
				 equipement = creatEquipement(i);
				employees[i] = new Programmer(id, name, age, salary,equipement);
				break;
			case DESIGNER:
				equipement = creatEquipement(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipement, bonus);
				break;
			case ARCHITECT:
				 equipement = creatEquipement(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipement, bonus, stock);
				break;
			}
					
			
		}
	}
	/**
	 * 
	 * 获取指定index上的员工的设备
	 * @param i
	 */
	private Equipement creatEquipement(int index) {
	int key = 	Integer.parseInt(EQUIPMENTS[index][0]);
	String modelOrName = EQUIPMENTS[index][1];
	
		switch(key) {
		case PC://21
			return new PC(modelOrName, EQUIPMENTS[index][2]);
		case NOTEBOOK://22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
		return new NoteBook(modelOrName,price);
		case PRINTER://23
			
			return new Printer(modelOrName, EQUIPMENTS[index][2]);
			
		}
		return null;
	}
/**
 * 获取当前所有员工
 * @return
 */
	public Employee[] getAllEmployees() {
		return employees;
	}
/**
	 * 获取指定ID的员工对象
	 * @param id
	 * @return
 *
	 */
	public Employee getEmployee(int id) throws TeamException {
		
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找到不到继承的员工");
		
	}
}

		
		
		
		