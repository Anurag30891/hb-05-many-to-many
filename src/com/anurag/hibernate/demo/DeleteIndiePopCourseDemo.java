package com.anurag.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anurag.hibernate.entity.Course;
import com.anurag.hibernate.entity.Instructor;
import com.anurag.hibernate.entity.InstructorDetail;
import com.anurag.hibernate.entity.Review;
import com.anurag.hibernate.entity.Student;

public class DeleteIndiePopCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int courseId = 11;
			
			Course tempCourse = session.get(Course.class, courseId);
			
			session.delete(tempCourse);
									
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
