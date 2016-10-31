package com.myssh.web;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myssh.entity.TbCls;
import com.myssh.service.TbClsService;

@Controller
@RequestMapping("/clsAction")
public class TbClsAction {
	@Resource
	private TbClsService clsService ;
	//��Ӱ༶
	@RequestMapping("/addTbCls")
	public String addTbCls(TbCls cls,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=utf-8");
		if(clsService.addTbCls(cls)){
			out.print("<script>alert('��Ӱ༶�ɹ�');location.href='/studentCls/pages/tbcls_add.jsp';</script>");
		}else{
			out.print("<script>alert('��Ӱ༶ʧ��');location.href='/studentCls/pages/tbcls_add.jsp';</script>");
		}
		return null;
	}
	//��ѯ�����еİ༶
	@RequestMapping("/showAllTbCLs")
	@ResponseBody
	public List showAllTbCls(){
		//System.out.println("��ѯ���еİ༶");
		return clsService.tbClsShowList();
	}
	//ɾ���û�
	@RequestMapping("/deleteTbCls")
	@ResponseBody
	public String deleteTbCls(@RequestParam("cno")int id,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		if(clsService.deleteTbCls(clsService.tbClsById(id))){
			return "scuess";
		}else{
			return "error";
		}
	}
	//ȥ���޸�ҳ��
	@RequestMapping("/toUpdateTbCls")
	public void toUpdateTbCls(TbCls cls,HttpServletRequest request,PrintWriter out){
		 request.getSession().setAttribute("cls",clsService.tbClsById(cls.getCno()));
		 out.print("<script>location.href='/studentCls/pages/tbcls_update.jsp'</script>");
	}
	//�޸��û���Ϣ
	@RequestMapping("/updateTbCls")
	public String updateTbCls(TbCls cls,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=utf-8");
		if(clsService.updateTbCls(cls)){
			out.print("<script>alert('�û��޸ĳɹ�');location.href='/studentCls/pages/tbcls_showList.jsp';</script>");
		}else{
			out.print("<script>alert('�û��޸�ʧ��');location.href='/studentCls/pages/tbcls_showList.jsp';</script>");
		}
		return null ;
	}
	
	public void setClsService(TbClsService clsService) {
		this.clsService = clsService;
	}
}
