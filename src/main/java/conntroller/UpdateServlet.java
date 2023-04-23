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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDAo dao;
	ServletContext config;

	@Override
	public void init() throws ServletException {

		dao = new StudentDAo();
		config=getServletContext();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double marks = Double.parseDouble(request.getParameter("marks"));
		
		Student student=new Student(id, name, marks);
		

		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		

		int i = dao.updateStudentData(student, url, username, password);
		

		request.setAttribute("stud", student);

		request.getRequestDispatcher("jsp/Display.jsp").forward(request, response);


	}

}
