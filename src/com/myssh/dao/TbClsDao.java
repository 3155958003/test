package com.myssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myssh.entity.TbCls;
@Repository
public class TbClsDao extends BaseDao{
	//添加班级
	public boolean addTbCls(TbCls cls){
		getSession().save(cls);
		return true;
	}
	//查询所有的班级
	public List tbClsShowList(){
		return getSession().createQuery("from TbCls").list();
	}
	//根据Id查询班级
	public TbCls tbClsById(int id){
		return (TbCls) getSession().get(TbCls.class, id);
	}
	//删除班级
	public boolean deleteTbCls(TbCls cls){
		getSession().delete(cls);
		return true ;
	}
	//修改班级
	public boolean updateTbCls(TbCls cls){
		getSession().update(cls);
		return true;
	}
}
