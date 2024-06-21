package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoMysqlImpl;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {

	
	private DaoMysqlImpl mysqlImpl = new DaoMysqlImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		mysqlImpl.remove(id);
		
		resp.sendRedirect("Liste");
	}
}
