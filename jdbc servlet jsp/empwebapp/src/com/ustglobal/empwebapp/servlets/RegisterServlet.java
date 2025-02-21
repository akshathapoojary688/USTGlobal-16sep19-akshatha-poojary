package com.ustglobal.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.udtglobal.empwebapp.util.EmployeeDaoManager;
import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dto.EmployeeInfo;

/*servlet program need to take the values from the html
 * compared with the database
 * then respond the result
 * */

@WebServlet("/register") //it is doing instead of web.xml for path
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		EmployeeInfo info = new EmployeeInfo();
		info.setId(id);
		info.setName(name);
		info.setEmail(email);
		info.setPassword(password);
		
		EmployeeDAO dao = EmployeeDaoManager.getEmployeeDAO();
		boolean check = dao.registerEmployee(info);
		
		PrintWriter out = resp.getWriter();
		
		//for jsp
		String msg = "";
		
		
		if(check) {
			//for jsp
			msg = "registration completed";
			
//			out.println("<html>");
//			out.println("<h4> Registration completed</h4>");
//			out.println("</html>");
		}else {
			msg = "id cannot be found";
			
//			out.println("<html>");
//			out.println("<h4> id cannot be repeated</h4>");
//			out.println("</html>");
		}
		//jsp
		req.setAttribute("msg", msg);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
		dispatcher.forward(req, resp);
		
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
//		dispatcher.include(req, resp);
//		
	}
}
