package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoMysqlImpl;

@WebServlet({"","/Liste"})
public class ListUser extends HttpServlet {
	
	private static final String VUE_USERS = "/WEB-INF/liste.jsp";
	private DaoMysqlImpl mysqlImpl = new DaoMysqlImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", mysqlImpl.listUsers());
		getServletContext().getRequestDispatcher(VUE_USERS).forward(req, resp);
	}
}
