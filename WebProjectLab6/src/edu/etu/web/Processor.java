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
        // ��������� ���������� �� ������ �������
        String userName = request.getParameter("name");
        String color = request.getParameter("color");
        
        if (userName == null || color == null) {
        	// ��������� �� ������, ���� ������� ������ ��� ���������
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "�� ����� ���� �� ����������");
            return;
        }
        
        // ������� ������� �������� ���������� ���������
        Integer reqNum = (Integer) request.getSession().getAttribute("requestNum");
        if (reqNum == null) {
            // ���� �� ���� ���������, �� �������������� ���� ���������
            reqNum = 1;
        } else {
            // ����� �������� �������� ��������� �� �������
            reqNum++;
        }
        request.getSession().setAttribute("requestNum", reqNum);
        
        //������� ���� ���������� ���������
        Date lastDate = new Date(System.currentTimeMillis());
        request.getSession().setAttribute("lastDate", lastDate);
        
        // ���������� ������������ � Cookie
        Cookie cookiesUser = new Cookie("user.name", URLEncoder.encode(userName, "UTF-8"));
        
        // ���������� ����� � Cookie
        Cookie cookiesColor = new Cookie("user.color", URLEncoder.encode(color, "UTF-8"));
        
        // ��������� ������� ����� Cookie � ��������
        cookiesUser.setMaxAge(1000);
        cookiesColor.setMaxAge(1000);
        response.addCookie(cookiesUser);
        response.addCookie(cookiesColor);
        
        // ��������������� �� �������� � �����������
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
