package spring_demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring_demo.entity.Course;
import spring_demo.entity.Instructor;
import spring_demo.entity.InstructorDetail;
import spring_demo.entity.Review;
import spring_demo.entity.Student;

public class CreateCourseAndStudentDemoApp {
	
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
			
			Course tempCourseOne = new Course("Spring Boot");
			Course tempCourseTwo = new Course("MySql");
			
			session.save(tempCourseOne);
			session.save(tempCourseTwo);
			
			Student studentOne = new Student("Elshan", "Hacali", "elsen@mail.ru");
			Student studentTwo = new Student("Asim", "Fazli", "asim@mail.ru");
			Student studentThree = new Student("Rufat", "Dagli", "rufko@gmail.com");
			
			tempCourseOne.addStudent(studentOne);
			tempCourseOne.addStudent(studentTwo);
			tempCourseOne.addStudent(studentThree);
			
			tempCourseTwo.addStudent(studentTwo);
			tempCourseTwo.addStudent(studentThree);
			
			session.save(studentOne);
			session.save(studentTwo);
			session.save(studentThree);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			
			factory.close();
		}
	}

}












