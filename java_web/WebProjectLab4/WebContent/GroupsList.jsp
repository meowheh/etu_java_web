<%-- Автор: Мищенко А.В., Дата 21.02.2021, Стартовая страница:
Вывод заголовка таблицы --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" errorPage="/ErrorManager.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> Список музыкальных групп</title>
	</head>
	<body>
		<% request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		if (name == null)
		throw new IllegalArgumentException("Name expected");
		%>
		<h1> Список любимых музыкальных групп пользователя <%=name%></h1>
		<%@include file="ListData.jsp"%>
	</body>
</html>