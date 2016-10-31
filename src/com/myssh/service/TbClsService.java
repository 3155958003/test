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
	//��Ӱ༶
	public boolean addTbCls(TbCls cls){
		return clsDao.addTbCls(cls);
	}
	//��ѯ���еİ༶
	public List tbClsShowList(){
		return clsDao.tbClsShowList();
	}
	//����Id��ѯ�༶
	public TbCls tbClsById(int id){
		return clsDao.tbClsById(id);
	}
	//ɾ���༶
	public boolean deleteTbCls(TbCls cls){
		return clsDao.deleteTbCls(cls);
	}
	//�޸İ༶
	public boolean updateTbCls(TbCls cls){
		return clsDao.updateTbCls(cls);
	}
	public void setClsDao(TbClsDao clsDao) {
		this.clsDao = clsDao;
	}
}
