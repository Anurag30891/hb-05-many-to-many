package com.anurag.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anurag.hibernate.entity.Course;
import com.anurag.hibernate.entity.Instructor;
import com.anurag.hibernate.entity.InstructorDetail;
import com.anurag.hibernate.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course tempCourse = new Course("BAdminton in 30 days");
			tempCourse.addReview(new Review("Amazing courses and skills."));
			tempCourse.addReview(new Review("Best practice skills"));
			tempCourse.addReview(new Review("Worst course ever"));

			System.out.println("saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);

			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
