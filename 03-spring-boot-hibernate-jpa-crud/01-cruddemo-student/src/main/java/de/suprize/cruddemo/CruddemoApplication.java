package de.suprize.cruddemo;

import de.suprize.cruddemo.dao.StudentDAO;
import de.suprize.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return (runner) -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of `Student` objects
		List<Student> students = studentDAO.findAll();

		// display a list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a `Student` object
		System.out.println("Creating the `Student` object ...");
		Student student = new Student("Daffy", "Duck", "daffy@suprize.de");

		// save the `Student` object
		System.out.println("Saving the `Student` object ...");
		studentDAO.save(student);

		// display the id of the `Student` object
		int studentId = student.getId();
		System.out.println("Saved the `Student` object. Generated id: " + studentId);

		// retrieve the `Student` object based on the id: primary key
		System.out.println("Retrieving the `Student` object with id: " + studentId);
		Student retrievedStudent = studentDAO.findById(studentId);

		// display the `Student` object
		System.out.println("Found the student: " + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple `Student` objects
		System.out.println("Creating three new `Student` objects ...");
		Student student1 = new Student("John", "Doe", "john@suprize.de");
		Student student2 = new Student("Mary", "Public", "mary@suprize.de");
		Student student3 = new Student("Bonita", "Applebum", "bonita@suprize.de");

		// persist the `Student` objects
		System.out.println("Saving the `Student` objects ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the `Student` object
		System.out.println("Creating new `Student` object ...");
		Student student = new Student("Paul", "Doe", "paul@suprize.de");

		// persist the `Student` object
		System.out.println("Saving the `Student` object ...");
		studentDAO.save(student);

		// display the id of the saved `Student` object
		System.out.println("Saved the `Student` object. Generated id: " + student.getId());
	}

}
