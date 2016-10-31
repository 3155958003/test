package com.myssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myssh.dao.TbStuDao;
import com.myssh.entity.TbStu;

@Service("tbStuService")
public class TbStuService {
	@Resource
	private TbStuDao tbStuDao ;
	
	//添加学生
	public boolean addTbStu(TbStu stu){
		return tbStuDao.addTbStu(stu);
	}
	//查询出所有的学生
	public List showAllTbStu(){
		return tbStuDao.showAllTbStu();
	}
	//查询出学生的Id
	public TbStu getTbStuById(int id){
		return tbStuDao.getTbStuById(id);
	}
	//删除学生
	public boolean deleteTbStu(TbStu stu){
		
		 TbStu stus = tbStuDao.getTbStuById(stu.getSno());
		
		return tbStuDao.deleteTbStu(stus);
	}
	//修改学生
	public boolean updateTbStu(TbStu stu){
		return tbStuDao.updateTbStu(stu);
	}
	
	public void setTbStuDao(TbStuDao tbStuDao) {
		this.tbStuDao = tbStuDao;
	}
}
