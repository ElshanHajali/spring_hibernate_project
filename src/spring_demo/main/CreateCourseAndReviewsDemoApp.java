package spring_demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring_demo.entity.Course;
import spring_demo.entity.Instructor;
import spring_demo.entity.InstructorDetail;
import spring_demo.entity.Review;

public class CreateCourseAndReviewsDemoApp {
	
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
			
			Course tempCourse = new Course("Spring Boot");
			
			tempCourse.addReview(new Review("Cool content"));
			tempCourse.addReview(new Review("I loved it"));
			tempCourse.addReview(new Review("Let's start"));
			tempCourse.addReview(new Review("What a good course"));
			
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			
			factory.close();
		}
	}

}












