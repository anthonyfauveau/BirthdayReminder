package fr.anthony.birthdayReminder.controlers;



import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import  static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import fr.anthony.birthdayReminder.dto.BirthdayDTO;
import fr.anthony.birthdayReminder.dto.UserDTO;
import fr.anthony.birthdayReminder.models.Birthday;
import fr.anthony.birthdayReminder.models.User;
import fr.anthony.birthdayReminder.repositories.BirthdayRepository;
import fr.anthony.birthdayReminder.repositories.UserRepository;
import fr.anthony.birthdayReminder.services.BirthdayService;
import fr.anthony.birthdayReminder.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BirthdayService birthdayService;

	@GetMapping(value = { "", "/" })
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") Long id) {
		return userService.getUserById(id);
	}

	@PostMapping("/{userId}/birthdays")
	public Birthday createBirthday(@PathVariable("userId") Long id, @RequestParam("firstname") final String firstname,
			@RequestParam("lastname") final String lastname, @RequestParam("date") final String date) {

		User user = userService.getUserById(id);
		Birthday birthday = new Birthday(id, LocalDate.parse(date), firstname, lastname, user);

		return birthdayService.save(birthday);
	}

}