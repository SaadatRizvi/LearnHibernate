package com.travelie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.travelie.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");;
			Student tempStudent = new Student("Saadat", "Rizvi", "gmail@saadat.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the Student ...");
			session.save(tempStudent);
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
