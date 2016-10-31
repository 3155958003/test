package com.myssh.web;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.beanvalidation.ActivationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myssh.dao.TbStuDao;
import com.myssh.entity.TbCls;
import com.myssh.entity.TbStu;
import com.myssh.service.TbClsService;
import com.myssh.service.TbStuService;

@Controller
@RequestMapping("/tbStuAction")
public class TbStuAction {

	private TbStu stu;

	@Resource
	private TbClsService tbClsService;
	@Resource
	private TbStuService tbStuService;

	// 去到班级中查询所有的班级
	@RequestMapping("/showTbCls")
	public void showTbCls(TbCls cls, HttpServletRequest request, PrintWriter out) {
		request.getSession().setAttribute("showTbCls", tbClsService.tbClsShowList());
		out.print("<script>location.href='/studentCls/pages/tbstu_add.jsp'</script>");
	}

	// 添加学生
	@RequestMapping("/addTbStu")
	public String addTbStu(TbStu stu, HttpServletResponse response, PrintWriter out) {
		response.setContentType("text/html;charset=utf-8");
		if (tbStuService.addTbStu(stu)) {
			out.print("<script>alert('添加学生成功');location.href='/studentCls/pages/tbstu_add.jsp';</script>");
		} else {
			out.print("<script>alert('添加学生失败');location.href='/studentCls/pages/tbstu_add.jsp';</script>");
		}
		return null;
	}

	// 查询所有的学生
	@RequestMapping("/showAllTbStuList")
	public String showAllTbStuList(HttpServletRequest request, PrintWriter out) {
		request.setAttribute("stuList", tbStuService.showAllTbStu());
		return "tbstu_showList";

	}

	// 删除学生
	@RequestMapping("/deleteTbStu")
	public String deleteTbStu(TbStu stu, HttpServletResponse response, PrintWriter out) {
		response.setContentType("text/html;charset=utf-8");

		if (tbStuService.deleteTbStu(stu)) {
			out.print("<script>alert('删除学生成功');location.href='/studentCls/tbStuAction/showAllTbStuList'</script>");
		} else {
			out.print("<script>alert('删除学生失败');history.back();</script>");
		}
		return null;
	}

	// 去到要修改的学生页面
	@RequestMapping("/toUpdateTbStu")
	public String toUpdateTbStu() {
		stu = new TbStuDao().getTbStuById(stu.getSno()) ;
		System.out.println(stu);
		return "tbstu_update";
	}

	// 修改学生
	@RequestMapping("/updateTbStu")
	public String updateTbStu(TbStu stu, HttpServletResponse response, PrintWriter out) {
		response.setContentType("text/html;charset=utf-8");
		if (tbStuService.updateTbStu(stu)) {
			out.print("<script>alert('修改学生成功');location.href='/studentCls/pages/tbstu_showList.jsp';</script>");
		} else {
			out.print("<script>alert('修改学生失败');location.href='/studentCls/pages/tbstu_showList.jsp';</script>");
		}
		return null;
	}

	public void setTbClsService(TbClsService tbClsService) {
		this.tbClsService = tbClsService;
	}

	public void setTbStuService(TbStuService tbStuService) {
		this.tbStuService = tbStuService;
	}

	public TbStu getStu() {
		return stu;
	}

	public void setStu(TbStu stu) {
		this.stu = stu;
	}

}
