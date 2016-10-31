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
<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.js"></script>
</head>
<body>
	<h1>班级信息列表</h1>
	<table id="tab" border="1" width="600">
	<tr>
	<td>编号</td><td>班级名称</td><td>管理</td>
	</tr>
	</table>
</body>
</html>
<script type="text/javascript">
	function loadData(){
		$.post("<%=basePath%>clsAction/showAllTbCLs","",function(data){
			$.each(data,function(i,v){
				//alert(data);
				var str="<tr>";
					str+="<td>"+(i+1)+"</td>";
					str+="<td>"+v.cname+"</td>";
					str+="<td><a href='<%=basePath%>clsAction/toUpdateTbCls?cno="+v.cno+"'>修改</a>&nbsp;|&nbsp;<a href='javascript:doDelete("+v.cno+")'>删除</a></td>";
					str+="</tr>";
					$("#tab").append(str);
			});
		});
	}
	window.onload=loadData();
	function doDelete(cno){
		$.post("<%=basePath%>clsAction/deleteTbCls","cno="+cno,function(data){
			//alert(data);
			if(data!=null){
				if("scuess"==data){
					alert("删除成功");
					location.reload(0);
				}else{
					alert("删除失败");
					history.back();
				}
			}
		});
	}
</script>








