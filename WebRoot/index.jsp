<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    	<a href="<%=basePath%>Resource/WECHAT.apk">download WECHAT</a>
    	<h1>
    		Your IP is :
    	</h1>
    	<h1>
    		${IP}
    	</h1>
    	
    	<h1>
    		Your addr is :
    	</h1>
    	<h1>
    		${addr}
    	</h1>
    	<h1>
    		Your ports size is :
    	</h1>
    	<h1>
    		${ports}
    	</h1>
    	<h1>
    		Your port is :
    	</h1>
    	<h1>
    		${port}
    	</h1>
  </body>
</html>
