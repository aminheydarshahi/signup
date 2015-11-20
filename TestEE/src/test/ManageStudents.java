package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import testHibernate.Student;


public class ManageStudents {

	public static void main(String[] args) {
		   
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session=factory.openSession();
	      
	    //creating transaction object  
	    Transaction tx=session.beginTransaction();  
	          
	    Student e1=new Student();  
	    e1.setID(1234);
	    e1.setName("aghaaliagha");  
	      
	    session.persist(e1);//persisting the object  
	    tx.commit();//transaction is committed
	    session.close();
	    
	    Session session2 = factory.openSession();
	    session2.beginTransaction();
	    Student student = (Student) session2.get(Student.class, new Integer(0));
	    System.out.println("successfully saved");  
	    System.out.println(student.getName());
	    
	    
	    
	
		
	}
}
