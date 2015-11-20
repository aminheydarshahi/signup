package testServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import testHibernate.Student;

@WebServlet(description = "login servlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GG!--------------");
		PrintWriter writer = response.getWriter();
		writer.println("GG shod");
		writer.println("Hello " + request.getParameter("user"));
		writer.println("ID: " + request.getParameter("id"));
		Student newStud = new Student();
		newStud.setID(Integer.parseInt(request.getParameter("id")));
		newStud.setName(request.getParameter("user"));
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(newStud);
		tx.commit();
		session.close();
		writer.close();
		
		
	}
	
	
	
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		System.out.println("GG!--------------");
//		
//	
//		
//		response.getWriter().println("EZ");
//		response.getWriter().flush();
//		
//		
//		
//	}
}
