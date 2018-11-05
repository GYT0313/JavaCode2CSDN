package org.csdn.gyt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BlogServlet1
 */
@WebServlet("/BlogServlet1")
public class BlogServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// ��ȡ����ֵ
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		// ���������̨
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		// �����ض���
		// ���ò���ֵ
//		request.setAttribute("newName", "sendRedirect");
//		response.sendRedirect("/class02/BlogServlet2");
		
		// ����ת��
		// ���ò���ֵ
		request.setAttribute("newName", "RequestDispatcher");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BlogServlet2");
		requestDispatcher.forward(request, response);
	}

}
