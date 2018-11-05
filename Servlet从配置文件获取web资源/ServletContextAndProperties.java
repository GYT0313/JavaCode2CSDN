package org.csdn.gyt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Properties")
public class ServletContextAndProperties extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = this.getServletContext();
		
		/*第一种获取方式*/
		String path = context.getRealPath("WEB-INF/classes/test.properties");
		FileInputStream inputStream = new FileInputStream(path);
		Properties properties1 = new Properties();
		properties1.load(inputStream);
		out.println("method 1:");
		out.println("name: " + properties1.getProperty("name"));
		out.println("age: " + properties1.getProperty("age"));
		
		out.println();
		
		/*第二种获取方式*/
		Properties properties2 = new Properties();
		properties2.load(context.getResourceAsStream("WEB-INF/classes/test.properties"));
		out.println("method 2:");
		out.println("name: " + properties1.getProperty("name"));
		out.println("age: " + properties1.getProperty("age"));
	}
	
}
