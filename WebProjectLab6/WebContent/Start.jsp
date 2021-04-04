<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Авторизация</title>
	</head>
	<body>
 		<form METHOD=GET action="Processor">Введите имя пользователя<br>
        <INPUT TYPE=TEXT NAME="name"
            <%
            // Выбор всех Cookie
        	Cookie [] cookies = request.getCookies();
            	if (cookies != null)
                	for (int i = 0; i < cookies.length; i++)
                		if ("user.name".equals(cookies[i].getName())) {
                			// Запись значения в поле ввода, если найден Cookie
                    		out.print(" value='" + URLDecoder.decode(cookies[i].getValue(), "UTF-8") + "' ");
                    		break;
                		}
            %>
        ><br>Введите цвет для отображения<br>
        <INPUT TYPE=TEXT NAME="color"
            <%
            if (cookies != null)
                for (int i = 0; i < cookies.length; i++)
                    if ("user.color".equals(cookies[i].getName())) {
                        // Запись значения в поле ввода, если найден Cookie
                        out.print(" value='" + URLDecoder.decode(cookies[i].getValue(), "UTF-8") + "' ");
                        break;
                    }
            %>
        ><br><INPUT TYPE=SUBMIT value="Ввод">
    </form>
	</body>	
</html>
