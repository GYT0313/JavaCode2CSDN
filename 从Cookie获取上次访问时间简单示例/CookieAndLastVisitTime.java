package org.csdn.gyt;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CookieAndLastAccessTime
 */
@WebServlet("/CookieAndLastVisitTime")
public class CookieAndLastVisitTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieAndLastVisitTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		String lastVistiTime = null;
		// 获取Cooikes
		Cookie[] cookies = request.getCookies();
		// 判断cookies是否符合条件
		for (int i=0; cookies != null && i < cookies.length; i++) {
			if ("lastVisit".equals(cookies[i].getName())) {
				lastVistiTime = cookies[i].getValue();
				break;
			}
		}
		// 判断是否为初次访问
		if (lastVistiTime == null) {
			response.getWriter().println("Welcome, you are visiting our website for the first time.");
		} else {
			response.getWriter().println("Welcome, your last visit is " + lastVistiTime);
		}
		// 设置本次访问的时间
		Cookie cookie = new Cookie("lastVisit", new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss").format(new Date()));
		cookie.setMaxAge(30);
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
