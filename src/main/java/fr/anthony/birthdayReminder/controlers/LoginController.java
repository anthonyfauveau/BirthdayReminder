package fr.anthony.birthdayReminder.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.anthony.birthdayReminder.models.User;
import fr.anthony.birthdayReminder.services.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public User getToken(@RequestParam("username") final String username,
			@RequestParam("password") final String password) {

		return userService.login(username, password);
	}
}