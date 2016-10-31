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
	//添加班级
	@RequestMapping("/addTbCls")
	public String addTbCls(TbCls cls,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=utf-8");
		if(clsService.addTbCls(cls)){
			out.print("<script>alert('添加班级成功');location.href='/studentCls/pages/tbcls_add.jsp';</script>");
		}else{
			out.print("<script>alert('添加班级失败');location.href='/studentCls/pages/tbcls_add.jsp';</script>");
		}
		return null;
	}
	//查询出所有的班级
	@RequestMapping("/showAllTbCLs")
	@ResponseBody
	public List showAllTbCls(){
		//System.out.println("查询所有的班级");
		return clsService.tbClsShowList();
	}
	//删除用户
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
	//去到修改页面
	@RequestMapping("/toUpdateTbCls")
	public void toUpdateTbCls(TbCls cls,HttpServletRequest request,PrintWriter out){
		 request.getSession().setAttribute("cls",clsService.tbClsById(cls.getCno()));
		 out.print("<script>location.href='/studentCls/pages/tbcls_update.jsp'</script>");
	}
	//修改用户信息
	@RequestMapping("/updateTbCls")
	public String updateTbCls(TbCls cls,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=utf-8");
		if(clsService.updateTbCls(cls)){
			out.print("<script>alert('用户修改成功');location.href='/studentCls/pages/tbcls_showList.jsp';</script>");
		}else{
			out.print("<script>alert('用户修改失败');location.href='/studentCls/pages/tbcls_showList.jsp';</script>");
		}
		return null ;
	}
	
	public void setClsService(TbClsService clsService) {
		this.clsService = clsService;
	}
}
