package com.travelie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.travelie.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 3;
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: "+ studentId);
			
			Student myStudent = session.get(Student.class,studentId );
			
					 System.out.println("Updating Student");
					 myStudent.setFirstName("Raheel");
					 session.getTransaction().commit();
					
					 session  = factory.getCurrentSession();
					 session.beginTransaction();
					 
					 session.createQuery("update Student set email='afridi@giki.edu.pk' where"
					 		+ " firstName='Afridi'").executeUpdate();
					 session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
