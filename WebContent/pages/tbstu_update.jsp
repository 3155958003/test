<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>修改学生</h1>
	<form action="<%=basePath%>tbStuAction/updateTbStu" method="post">
			   <input type="hidden" name="sno" value="${stu.sno }"/>
		学生姓名:<input name="sname" value="${stu.sname }"/><br/>
		学生年龄:<input name="sage" value="${stu.sage }"/><br/>
		学生性别:<input type="radio" value="${stu.ssex }" name="ssex"/>男
		       <input type="radio" value="${stu.ssex }" name="ssex"/>女<br/>
		入学时间:<input name="sintime" value="${stu.sintime }"/><br/>
		学生班级:<select name="stu.tbcls.cno">
					<option value="">${stu.cname }</option>
					<c:forEach items="${showTbCls}" var="s">
						<option value="${s.cno}">${s.cname }</option>
					</c:forEach>
			   </select><br/>
			   <input type="submit" value="修改"/>
	</form>
	<br/>
</body>
</html>