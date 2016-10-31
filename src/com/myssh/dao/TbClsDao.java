package com.myssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myssh.entity.TbCls;
@Repository
public class TbClsDao extends BaseDao{
	//��Ӱ༶
	public boolean addTbCls(TbCls cls){
		getSession().save(cls);
		return true;
	}
	//��ѯ���еİ༶
	public List tbClsShowList(){
		return getSession().createQuery("from TbCls").list();
	}
	//����Id��ѯ�༶
	public TbCls tbClsById(int id){
		return (TbCls) getSession().get(TbCls.class, id);
	}
	//ɾ���༶
	public boolean deleteTbCls(TbCls cls){
		getSession().delete(cls);
		return true ;
	}
	//�޸İ༶
	public boolean updateTbCls(TbCls cls){
		getSession().update(cls);
		return true;
	}
}
