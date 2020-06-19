package webapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class imagedownloader
 */
@WebServlet("/imagedownloader")
public class imagedownloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("success");
	HttpSession ss=request.getSession();
	int id=(int)ss.getAttribute("id");
		datadao dao=new datadao();
	byte[] image=dao.getimage(id);
	System.out.println("success2");
	ServletOutputStream outputStream = null;
	outputStream = response.getOutputStream();
	outputStream.write(image);
	outputStream.close();
	}

	

}
