<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>添加班级</h1>
	<form action="<%=basePath%>clsAction/updateTbCls" method="post">
			   <input type="hidden" name="cno" value="${cls.cno }"/>
		班级名称:<input name="cname" value="${cls.cname }"/><br/>
			   <input type="submit" value="添加"/>
	</form>
	<br/>
</body>
</html>