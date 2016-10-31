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
	<h1>添加学生</h1>
	<form action="<%=basePath%>tbStuAction/addTbStu" method="post">
		学生姓名:<input name="sname"/><br/>
		学生年龄:<input name="sage"/><br/>
		学生性别:<input type="radio" value="男" name="ssex"/>男
		       <input type="radio" value="女" name="ssex" checked/>女<br/>
		入学时间:<input name="sintime"/><br/>
		学生班级:<select name="tbcls.cno">
					<option value="">请选择班级</option>
					<c:forEach items="${showTbCls }" var="s">
						<option value="${s.cno}">${s.cname }</option>
					</c:forEach>
			   </select><br/>
			   <input type="submit" value="添加"/>
	</form>
	<br/>
	
	<a href="<%=basePath%>tbStuAction/showAllTbStuList">查询所有的学生</a>
</body>
</html>