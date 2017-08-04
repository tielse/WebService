package com.chauthoiit.kali.views;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chauthoiit.kali.dao.AdminDAOImpl;
import com.chauthoiit.kali.model.Admin;
import com.chauthoiit.kali.tools.Decode;
import com.chauthoiit.kali.utils.ConnectionPool;

/**
 * Servlet implementation class AdminHttp
 */
@WebServlet(name = "AdminHttp", urlPatterns = { "/AdminHttp" })
public class AdminHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// private final String web_home = "index.jsp";
	private final String web_Admin_home = "Admin/index.jsp";
	private final String web_login = "login.jsp";
	private final String web_error = "error.jsp";
	private ConnectionPool cp;
	private AdminDAOImpl Impl = new AdminDAOImpl(cp);

	public AdminHttp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void CleanSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (req.getParameter("command").equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect(web_login);
		}
	}

	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			String user = req.getParameter("txt_username");
			String pass = req.getParameter("txt_password");
			String acttion = req.getParameter("bt_click");
			Admin admin = new Admin();
			admin.setAdmin_user(user);
			// String err = "";
			admin.setAdmin_password(Decode.DecodeMD5(pass));
			if (acttion.equals("Login")) {
				String url = web_login;
				if (user.equals("") || pass.equals("")) {
					// err = "Required username and password!";
					resp.sendRedirect(web_login);
				} else if (Impl.checkLogin(pass) == true) {
					try {
						// int t = Impl.getAdmin(user).getAdmin_permission();
						// System.out.println("T:" + t);
						HttpSession s = req.getSession();
						s.setAttribute("username", user);
						url = web_Admin_home;
						resp.sendRedirect(url);
					} catch (Exception e) {
						// TODO: handle exception
						Logger.getLogger(AdminHttp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher(web_error);
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(AdminHttp.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		processRequest(request, response);
	}

}
