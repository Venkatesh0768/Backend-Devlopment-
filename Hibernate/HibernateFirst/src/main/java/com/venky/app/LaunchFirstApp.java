package com.venky.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.venky.model.Students;

public class LaunchFirstApp { 
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		List<Students> students = session
//		        .createQuery("from Students", Students.class)
//		        .getResultList();

		Students studentList = session.getReference(Students.class , 1);
		System.out.println(studentList.getName()  + "  "+ studentList.getCity());
//		students.forEach(s -> System.out.println( s.getId() + "  " + s.getName() + " " + s.getCity()));

		
		transaction.commit();
		session.close();
		
	}

}
