package com.myssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myssh.dao.TbClsDao;
import com.myssh.entity.TbCls;
@Service
public class TbClsService {
	@Resource
	private TbClsDao clsDao ;
	//添加班级
	public boolean addTbCls(TbCls cls){
		return clsDao.addTbCls(cls);
	}
	//查询所有的班级
	public List tbClsShowList(){
		return clsDao.tbClsShowList();
	}
	//根据Id查询班级
	public TbCls tbClsById(int id){
		return clsDao.tbClsById(id);
	}
	//删除班级
	public boolean deleteTbCls(TbCls cls){
		return clsDao.deleteTbCls(cls);
	}
	//修改班级
	public boolean updateTbCls(TbCls cls){
		return clsDao.updateTbCls(cls);
	}
	public void setClsDao(TbClsDao clsDao) {
		this.clsDao = clsDao;
	}
}
