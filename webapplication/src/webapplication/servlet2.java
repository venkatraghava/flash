package webapplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	datadao dao=new datadao();
	data d=dao.getdata(username,password);
	HttpSession ss=request.getSession();
	ss.setAttribute("id", d.id);
	PrintWriter out=response.getWriter();
	
	if(d.name==null)
	out.println("fail");
	else
	{
		request.setAttribute("name",d.name);
		request.setAttribute("collegename",d.collegename);
		request.setAttribute("id",d.id);
		request.setAttribute("email",d.email);
		request.setAttribute("username",d.username);
		RequestDispatcher dispatcher=request.getRequestDispatcher("index2.jsp");
	   dispatcher.forward(request,response);
	}
	out.close();
	}

}
