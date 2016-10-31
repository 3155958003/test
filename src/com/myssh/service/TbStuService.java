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
	
	//���ѧ��
	public boolean addTbStu(TbStu stu){
		return tbStuDao.addTbStu(stu);
	}
	//��ѯ�����е�ѧ��
	public List showAllTbStu(){
		return tbStuDao.showAllTbStu();
	}
	//��ѯ��ѧ����Id
	public TbStu getTbStuById(int id){
		return tbStuDao.getTbStuById(id);
	}
	//ɾ��ѧ��
	public boolean deleteTbStu(TbStu stu){
		
		 TbStu stus = tbStuDao.getTbStuById(stu.getSno());
		
		return tbStuDao.deleteTbStu(stus);
	}
	//�޸�ѧ��
	public boolean updateTbStu(TbStu stu){
		return tbStuDao.updateTbStu(stu);
	}
	
	public void setTbStuDao(TbStuDao tbStuDao) {
		this.tbStuDao = tbStuDao;
	}
}
