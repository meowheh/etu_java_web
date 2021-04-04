package edu.etu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Processor
 */
@WebServlet("/Processor")
public class Processor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Processor() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        // Получение параметров из строки запроса
        String userName = request.getParameter("name");
        String color = request.getParameter("color");
        
        if (userName == null || color == null) {
        	// Сообщение об ошибке, если сервлет вызван без параметов
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Не задан один из параметров");
            return;
        }
        
        // Получим текущее значение количества обращений
        Integer reqNum = (Integer) request.getSession().getAttribute("requestNum");
        if (reqNum == null) {
            // Если не было обращений, то инициализируем одно обращение
            reqNum = 1;
        } else {
            // Иначе увеличим значение обращений на единицу
            reqNum++;
        }
        request.getSession().setAttribute("requestNum", reqNum);
        
        //Получим дату последнего обращения
        Date lastDate = new Date(System.currentTimeMillis());
        request.getSession().setAttribute("lastDate", lastDate);
        
        // Сохранение пользователя в Cookie
        Cookie cookiesUser = new Cookie("user.name", URLEncoder.encode(userName, "UTF-8"));
        
        // Сохранение цвета в Cookie
        Cookie cookiesColor = new Cookie("user.color", URLEncoder.encode(color, "UTF-8"));
        
        // Установка времени жизни Cookie в секундах
        cookiesUser.setMaxAge(1000);
        cookiesColor.setMaxAge(1000);
        response.addCookie(cookiesUser);
        response.addCookie(cookiesColor);
        
        // Перенаправление на страницу с информацией
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/Output.jsp"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
