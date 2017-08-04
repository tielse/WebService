package com.chauthoiit.kali.views;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chauthoiit.kali.model.Admin;
import com.chauthoiit.kali.utils.MyUtils;

/**
 * Servlet implementation class AdminInfoHttp
 */
@WebServlet(name = "AdminInfoHttp", urlPatterns = { "/AdminInfoHttp" })
public class AdminInfoHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String web_Admin_home = "Admin/index.jsp";
	private final String web_login = "login.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminInfoHttp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void processHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();

		Admin admin = MyUtils.getloginedAdmin(session);
		if (admin == null) {
			resp.sendRedirect(web_login);
			return;
		}
		req.setAttribute("user", admin);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(web_Admin_home);
		rd.forward(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		processHttp(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processHttp(request, response);
	}

}
