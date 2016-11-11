package com.travelie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.travelie.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();



Session session = factory.getCurrentSession();

try {
System.out.println("Creating new student objects...");;
Student tempStudent1 = new Student("Usman", "dsazvi", "gmail@tatta.com");
Student tempStudent2 = new Student("Jameel", "Jameela", "gmail@jamalgotha.com");
Student tempStudent3 = new Student("Ricardo", "kaka", "gmail@kaka.com");
session.beginTransaction();

System.out.println("Saving the Student ...");
session.save(tempStudent1);
session.save(tempStudent2);
session.save(tempStudent3);
session.getTransaction().commit();

System.out.println("Done");

}
finally {
factory.close();
}



	}

}
