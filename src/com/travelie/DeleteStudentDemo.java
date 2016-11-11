package com.travelie;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.travelie.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		
		
		Session session = factory.getCurrentSession();
		List<Student> myStudents ;
		try {
			//creating a new sample student
			System.out.println("Creating new student object...");;
			Student tempStudent = new Student("Saud", "Jiwani", "Jiwanil@roxxX.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the Student ...");
			session.save(tempStudent);
			session.getTransaction().commit();
			
			System.out.println("Done");
			session = factory.getCurrentSession();
			session.beginTransaction();
			myStudents = session.createQuery("from Student s where "
					+ "s.firstName='Saud'").getResultList();
			
			session.getTransaction().commit();
			
			int studentId = myStudents.get(myStudents.size()-1).getId();
			
			System.out.println("StudentId: "+ studentId);
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			
			Student myStudent = session.get(Student.class,studentId );
			System.out.println("\n Deleting Student: "+ myStudent);
			
					session.delete(myStudent);
			
			System.out.println("Deleting student with id =4");
			session.createQuery("delete from Student where id=4").executeUpdate();
					
					 session.getTransaction().commit();
			System.out.println("Done");
			
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
