package edu.etu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * Servlet implementation class MusicGroupsList
 * @author 7306 Mischenko Alina
 * 
 */
@WebServlet("/MusicGroupsList")
public class MusicGroupsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicGroupsList() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
    methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		 throws ServletException, IOException {
	    // Задание типа кодировки для параметров запроса
	    request.setCharacterEncoding("utf-8");
	     // Чтение параметра name из запроса
	     String name = request.getParameter("name");
	     //Чтение парамета lang из запроса
	     String lang = request.getParameter("lang");
	     if(lang == null)
	     {
	            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
	                    "Параметр lang не найден");
	            return;
	     }
	     if(!"en".equalsIgnoreCase(lang) && !"ru".equalsIgnoreCase(lang)) 
	     {
	    	 response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
	    	"Параметр lang может принимать значения en или ru");
	    	 return;
	     }
	        
	     ResourceBundle res = ResourceBundle.getBundle("resources/groups", "en".equalsIgnoreCase(lang) ? 
	    		 Locale.ENGLISH : Locale.getDefault());
	     // Задание типа содержимого для ответа (в том числе кодировки)
	     response.setContentType("text/html;charset=UTF-8");
	     // Получение потока для вывода ответа
	     PrintWriter out = response.getWriter();
	     try {
	     // Создание HTML-страницы
		     out.println("<html>");
		     out.println("<head><title>" + res.getString("title") + "</title></head>");
		     out.println("<body>");
		     out.println("<h1>");
		     out.println(res.getString("mainText") + " "+ (name != null ? name :res.getString("noName")) + "</h1>");
		     out.println("<table border='1'>");
		     out.println("<tr><td><b>" + res.getString("groupName") + "</b></td><td><b>" +
		     res.getString("country") + "</b></td><td><b>" + res.getString("consert")  + "</b></td></tr>");
		     out.println("<tr><td> источник </td><td> Россия </td><td> Да </td></tr>");
		     out.println("<tr><td> IDLES </td><td> Великобритания </td><td> Нет </td></tr>");
		     out.println("<tr><td> BLACKPINK </td><td> Южная Корея </td><td> Нет </td></tr>");
		     out.println("<tr><td> Алиса </td><td> Россия </td><td> Да </td></tr>");
		     out.println("</table>");
		     out.println("</body>");
		     out.println("</html>");
	     } 
	     finally 
	     {
	     // Закрытие потока вывода
	    	 out.close();
	     }
     }
     /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
     /**
      * Handles the HTTP
      * <code>POST</code> method.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
      @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
