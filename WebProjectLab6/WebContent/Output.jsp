<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Информация о пользователе</title>
	</head>
	<body>
 		<%
        	// Получим цвет текста и имя пользователя
        	String color = null;
        	String userName = null;
        	Cookie[] cookies = request.getCookies();
        	if(cookies != null)
            	for(int i = 0; i < cookies.length; i++) {
                	if("user.color".equals(cookies[i].getName())) {
                    	color = cookies[i].getValue();
                	} else if ("user.name".equals(cookies[i].getName())) {
                    	userName = cookies[i].getValue();
                	}
            	}
        	// Получим дату последнего обращения и количество запросов
        	Date lastReq = (Date) request.getSession().getAttribute("lastDate");
        	Integer reqNum = (Integer) request.getSession().getAttribute("requestNum");
   		%>
    	<font color="<%=color%>">
        	<h1>Информация о пользователе</h1>
        	<br><b>Имя пользователя: </b>
        	<%= URLDecoder.decode(userName, "UTF-8")%>
        	<br><b>Количество запросов: </b>
        	<%= reqNum%>
        	<br><b>Дата последнего запроса: </b>
        	<%= lastReq%>
        	<br><b>Текущий цвет: </b>
        	<%= URLDecoder.decode(color, "UTF-8")%>
    	</font>
	</body>
</html>
