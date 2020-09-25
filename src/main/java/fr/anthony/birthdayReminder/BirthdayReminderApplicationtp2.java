package fr.anthony.birthdayReminder;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.anthony.birthdayReminder.models.Birthday;
import fr.anthony.birthdayReminder.models.User;
import fr.anthony.birthdayReminder.services.BirthdayService;
import fr.anthony.birthdayReminder.services.UserService;


@ComponentScan("fr.*")
public class BirthdayReminderApplicationtp2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new
		AnnotationConfigApplicationContext(BirthdayReminderApplicationtp2.class);
		
		UserService userService = context.getBean("users", UserService.class);
		BirthdayService birthdayService = context.getBean("Birthdays", BirthdayService.class);
		
		User user1 = new User(1l, "Peter", "peter.bardu@gmail.com", "azerty");
		User user2 = new User(2l, "John", "John@gmail.com", "1234");
		userService.save(user1);
		userService.save(user2);
		
		Birthday birthday1 = new Birthday(1l, LocalDate.of(1994, 1, 21), "Robert", "De NiroJr", user1);
		Birthday birthday2 = new Birthday(1l, LocalDate.of(1997, 1, 31), "Anthony", "Fauveau", user2);
		Birthday birthday3 = new Birthday(1l, LocalDate.of(1994, 2, 02), "Peter", "Bardu", user1);
				
		birthdayService.save(birthday1);
		birthdayService.save(birthday2);
		birthdayService.save(birthday3);
		
		birthdayService.getAllBirthdays().stream().forEach(System.out::println);
		userService.getAllUsers().stream().forEach(System.out::println);
		
		
	}
	
}