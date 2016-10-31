package com.myssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myssh.entity.TbStu;

@Repository
public class TbStuDao extends BaseDao{
	//添加学生
	public boolean addTbStu(TbStu stu){
		getSession().save(stu);
		return true;
	}
	//查询出所有的学生
	public List showAllTbStu(){
		return getSession().createQuery("from TbStu s inner join s.tbcls").list();
	}
	//查询出学生的Id
	public TbStu getTbStuById(int id){
		return (TbStu) getSession().get(TbStu.class, id);
	}
	//删除学生
	public boolean deleteTbStu(TbStu stu){
		getSession().delete(stu);
		return true;
	}
	//修改学生
	public boolean updateTbStu(TbStu stu){
		getSession().update(stu);
		return true;
	}
}
