package com.anurag.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anurag.hibernate.entity.Course;
import com.anurag.hibernate.entity.Instructor;
import com.anurag.hibernate.entity.InstructorDetail;
import com.anurag.hibernate.entity.Review;
import com.anurag.hibernate.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//create course
			Course tempCourse = new Course("BAdminton in 30 days");
			
			//save the course
			System.out.println("saving the course");
			session.save(tempCourse);
			System.out.println("Saved course: "+tempCourse);
			
			//create Students
			Student tempStudent1 = new Student("Laksh", "Bhatt", "lola@gmail");
			Student tempStudent2 = new Student("Sumit", "Chaudary", "sumit@gmail");

			//add Students to course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			//save students
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("saved students: " + tempCourse.getStudents());

			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
