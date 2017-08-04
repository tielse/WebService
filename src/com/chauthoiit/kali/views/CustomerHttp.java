package com.chauthoiit.kali.views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chauthoiit.kali.dao.CustomerDAOImpl;
import com.chauthoiit.kali.model.Customer;
import com.chauthoiit.kali.tools.SendMail;
import com.chauthoiit.kali.utils.ConnectionPool;

/**
 * Servlet implementation class CustomerHttp
 */
@WebServlet(name = "CustomerHttp", urlPatterns = { "/CustomerHttp" })
public class CustomerHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String web_susscess = "susscess.jsp";
	private final String web_error = "error.jsp";
	private final String web_home = "index.jsp";
	private final String url = "http://mualban.esy.es";
	private ConnectionPool cp;
	private CustomerDAOImpl Impl = new CustomerDAOImpl(cp);
	private Customer customer;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerHttp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("static-access")
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html;charset=UTF-8");
		try {
			// Integer id = 1;
			String name = req.getParameter("txt_name");
			String email = req.getParameter("txt_email");
			String subject = req.getParameter("txt_subject");
			String message = req.getParameter("txt_message");
			String action = req.getParameter("bt_click");
			customer = new Customer(name, email, subject, message);
			if (action.equals("Login")) {
				if (name.equals("") || email.equals("") || subject.equals("") || message.equals("")) {
					resp.sendRedirect(web_error);
				} else {
					Impl.addCustomer(customer);
					SendMail send = new SendMail();
					send.sendMail(email, "Admin Kali Security ",
							"Hello,  " + name + "\nThe service you register is reviewed by the administrator.\r\n"
									+ "We will send the information as soon as possible.\r\n"
									+ "We on behalf of Kali Security Team sincerely thank you." + "\nLink: " + url);
					resp.sendRedirect(web_susscess);
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher(web_home);
				rd.forward(req, resp);
			}

		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerHttp.class.getName()).log(Level.SEVERE, null, e);
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
