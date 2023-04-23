package conntroller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Do.StudentDAo;
import modal.Student;

@WebServlet("/insert")
public class insert extends HttpServlet 
{	
	StudentDAo dao;
	ServletContext config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new StudentDAo();
		this.config = config.getServletContext();
	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException 
	{	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double marks = Double.parseDouble(request.getParameter("marks"));
		
		
		Student student=new Student(id, name, marks);
		
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		int i = dao.insertStudent(student ,url, username, password);
		
      
	        
			System.out.println("*****Insert DATA EXECUTES  *****");
			
			if (i == 1) {
				
				response.sendRedirect("jsp/Display.jsp");

			} else {
				out.print("<h1>NOT ADD </h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/Studentinfo.html");
				rd.include(request, response);
			}

		
	}

}
