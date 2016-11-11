package com.travelie;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.travelie.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> myStudents = session.createQuery("from Student s where s.email like '%gmail%'").getResultList();
			System.out.println("\nStudents with gmail in their email: \n");
			displayStudents(myStudents);
			
			myStudents = session.createQuery("from Student ").getResultList();
			System.out.println("\ndisplay all students: \n");
			displayStudents(myStudents);
			myStudents = session.createQuery("from Student s where"
					+ " s.lastName ='Rizvi' OR s.firstName='Afridi'").getResultList();
			System.out.println("\ndisplay lastname=Rizvi or firstname = Afridi: \n");
			displayStudents(myStudents);
			
			
			session.getTransaction().commit();
			
			
		}
		finally {
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> myStudents) {
		for(Student temp: myStudents){
			System.out.println(temp);
		}
	}

}
