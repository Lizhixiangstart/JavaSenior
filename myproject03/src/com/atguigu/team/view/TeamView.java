package com.atguigu.team.view;
/**
*@Description
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月6日 上午11:26:19
*类说明
*
*
*/

import org.w3c.dom.NameList;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;



public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	private Employee employee;
	
	public void enterMainMenu() {
		char menu = 0;
		boolean loopFlag = true;
		while(loopFlag) {
			if(menu != '1') {
		listAllEmployees();
			}
		System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4)");
		 menu = TSUtility.readMenuSelection();
		switch(menu) {
		case '1':
			getTeam();
			break;
		case '2':
			try {
				addMember();
			} catch (TeamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case '3':
			delecteMember();
			break;
		case '4':
			System.out.println("确认是否退出(Y/N):");
			char isExit = TSUtility.readConfirmSelection();
			if(isExit == 'Y') {
				loopFlag = false;
			}
			break;
			
			}
		}
	}
	/**
	 * 显示所有的员工信息
	 */
	public void listAllEmployees() {
//		System.out.println("显示所有的公司员工");
		System.out.println("--------开发团队调度软件--------");
		
		Employee[] employees = listSvc.getAllEmployees();
		if( employees == null || employees.length == 0) {
			System.out.println("公司中没有任何信息！");
		}else {
			System.out.println("ID\t性命\t年龄\t职位\t状态\t奖金\t股票\t领用设备");
			for(int i=0;i<employees.length;i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println("------------------");
	}
	public void getTeam() {
		System.out.println("查看开发团队");
		System.out.println("----------团员列表------");
		System.out.println("-----------------------");
		Programmer[] team = teamSvc.getTeam();
		if(team == null || team.length == 0) {
			System.out.println("开发团队目前没有成员");
		}else {
			System.out.println("TTD/ID\t姓名\t年龄\t工资\t职位\t奖金 股票\n");
			for(int i=0 ;i<team.length;i++) {
				System.out.println(team[i].getDetailsForTeam());
				
			}
		}
		
	}
	public void addMember() throws TeamException {
//		System.out.println("添加团队成员");
	System.out.println("--------添加成员--------");	
	System.out.println("请输入要添加的成员ID：");
	int id = TSUtility.readInt();
	
	try {
		Employee emp = listSvc.getEmployee(id);
		
		teamSvc.addMember(emp);
		System.out.println("添加成功");
		//按回车键继续 
		TSUtility.readReturn();
		
	} catch (TeamException e) {
		
		System.out.println("添加失败，原因："+e.getMessage());
	}
	
	}
	public void delecteMember() {
//		System.out.println("删除团队成员");
		System.out.println("请输入要删除的员工TID：");
		int memberId = TSUtility.readInt();
		System.out.println("请确认是否删除(Y/N)");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete == 'N') {
			return ;
		}
		try {
			teamSvc.removeMember(memberId);
		} catch (Exception e) {
			
			System.out.println("删除失败，原因："+e.getMessage());
		}
	}
	
	public static void main(String [] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();

	}
}
