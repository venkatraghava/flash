package webapplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	data d=new data();
	datadao dao=new datadao();
	d.name=request.getParameter("name");
	d.email=request.getParameter("email");
	d.collegename=request.getParameter("collegename");
	d.password=request.getParameter("password");
	d.propic=request.getParameter("propic");
	d.username=request.getParameter("username");
	d.id=Integer.parseInt(request.getParameter("id"));
	int res=dao.adddetails(d);
	if(res>0)
	{
		out.println("success");
	}
	else
	{
		out.println("fail");
	}
	}

}
