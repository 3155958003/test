package com.myssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myssh.entity.TbStu;

@Repository
public class TbStuDao extends BaseDao{
	//���ѧ��
	public boolean addTbStu(TbStu stu){
		getSession().save(stu);
		return true;
	}
	//��ѯ�����е�ѧ��
	public List showAllTbStu(){
		return getSession().createQuery("from TbStu s inner join s.tbcls").list();
	}
	//��ѯ��ѧ����Id
	public TbStu getTbStuById(int id){
		return (TbStu) getSession().get(TbStu.class, id);
	}
	//ɾ��ѧ��
	public boolean deleteTbStu(TbStu stu){
		getSession().delete(stu);
		return true;
	}
	//�޸�ѧ��
	public boolean updateTbStu(TbStu stu){
		getSession().update(stu);
		return true;
	}
}
