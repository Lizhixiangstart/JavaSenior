package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

/**
*@Description 关于开发团队的成员管理，添加，删除等
*@author lzx Email：1181776037@qq.com
*@version 创作时间：2021年12月4日 下午6:41:31
*类说明
*
*
*/
public class TeamService {
	private static int COUNTER=1;//给memberId赋值
	private  final int MAX_MEMBER = 5;//人数最大限制
	private Programmer [] team = new Programmer[MAX_MEMBER];//保存开发团队成员
	private int total ;//记录开发团队中实际的人数
	public TeamService() {
		super();
	}
	/**
	 * 获取开发团队中的所有成绩
	 * @return
	 */
	
	public Programmer [] getTeam() {
		Programmer [] team = new Programmer[total];
		for(int i=0;i<team.length;i++) {
			team[i] = this.team[i];
		}
		return team;
		
	}
	/**
	 * 将指定的员工添加到开发团队中
	 * @param e
	 */
	
	public void addMember(Employee e) throws TeamException{
		//成员已满，无法添加
		if(total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		//该成员不是开发人员，无法添加
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		//该成员已在本开发团队中
		if(isExist(e)) {
			throw new TeamException("该成员已在本开发团队中");
		}
		//该成员已是某团队成员
		
		//该成员正在休假，无法添加
		Programmer p = (Programmer)e;
		if("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团队成员");
			
		}else if("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工正在休假，无法参加");
			
		}
		
		
		
		//团队中至多只能有一名架构师
		//团队中至多只能有两名设计师
		//团队中至多只能有三名程序员
		
			//获取team已有成员中架构师，设计师，程序员的人数
		int numOfArch = 0,numOfDes = 0,numOfPro = 0;
		for(int i=0;i<team.length;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else if(team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		
		if(p instanceof Architect) {
			if(numOfArch >= 1) {
				throw new TeamException();
			}
		}
		else if(p instanceof Designer) {
			if(numOfDes >= 2) {
				throw new TeamException();
			}
		}
		else if(p instanceof Programmer) {
			if(numOfPro >=3) {
				throw new TeamException();
			}
		}
		//将p或（e）添加到现有的team中
		team[total++] = p;
		p.setStatus(Status.BUSY);
		p.setMemberId(COUNTER++);
	}

	
	 private boolean isExist(Employee e) {
		for(int i=0;i<total;i++) {
			
			return team[i].getId() == e.getId();
		}
		return false;
	}
	 /**
	  * 从团队中删除成员
	  * 
	  * @param memberId
	  */
	public void removeMember(int memberId) {
		int i=0;
		for(;i<total;i++) {
			if(team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		} 
		for(int j=i+1;j<total;j++) {
			team[j-1] = team[j];
		}
	 }
}
