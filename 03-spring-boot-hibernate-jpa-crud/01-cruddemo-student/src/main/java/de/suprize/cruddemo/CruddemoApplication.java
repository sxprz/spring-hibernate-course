package de.suprize.cruddemo;

import de.suprize.cruddemo.dao.StudentDAO;
import de.suprize.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return (runner) -> {
			createStudent(studentDAO);
		};
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
