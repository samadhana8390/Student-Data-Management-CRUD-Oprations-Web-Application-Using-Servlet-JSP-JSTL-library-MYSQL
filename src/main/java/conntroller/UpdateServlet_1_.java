package conntroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Do.StudentDAo;
import modal.Student;


@WebServlet("/UpdateServlet_1_")
public class UpdateServlet_1_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAo dao;
	ServletContext config;

	@Override
	public void init() throws ServletException {

		dao = new StudentDAo();
		config=getServletContext();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		String url=config.getInitParameter("url");
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");
		
	   
		Student stud=dao.updateServalet1(id,url,username,password);
		
		request.setAttribute("student", stud);
		
		request.getRequestDispatcher("jsp/Update.jsp").forward(request, response);
		
	}

}
