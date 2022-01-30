package spring_demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring_demo.entity.Course;
import spring_demo.entity.Instructor;
import spring_demo.entity.InstructorDetail;
import spring_demo.entity.Review;
import spring_demo.entity.Student;

public class CreateCourseAndAddToStudentTableDemoApp {
	
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

			int id12 = 12;
			int id13 = 13;
			
			Course tempCourse12 = session.get(Course.class, id12);
			Course tempCourse13 = session.get(Course.class, id13);
			
			Course tempCourseFive = new Course("JavaScript");
			Course tempCourseSix = new Course("HTML & CSS");
								
			session.save(tempCourseFive);
			session.save(tempCourseSix);

			int idOne = 1;
			int idTwo = 2;
			int idThree = 3;
			
			Student studentOne = session.get(Student.class, idOne);
			Student studentTwo = session.get(Student.class, idTwo);
			Student studentThree = session.get(Student.class, idThree);
			
			tempCourse12.addStudent(studentOne);
			tempCourse13.addStudent(studentOne);
			tempCourse13.addStudent(studentTwo);
			tempCourseFive.addStudent(studentOne);
			tempCourseFive.addStudent(studentThree);
			tempCourseSix.addStudent(studentOne);
			tempCourseSix.addStudent(studentTwo);
			tempCourseSix.addStudent(studentThree);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			
			factory.close();
		}
	}

}












