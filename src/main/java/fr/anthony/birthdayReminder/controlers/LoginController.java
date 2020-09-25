package fr.anthony.birthdayReminder.controlers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.anthony.birthdayReminder.models.User;
import fr.anthony.birthdayReminder.services.UserService;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping(value = {"","/"}, produces = APPLICATION_JSON_VALUE)
	public Optional<User> getLogin(@RequestBody User user){
		
		Optional<User> userVerif = userservice.login(user.getUsername(), user.getPassword());
		
	    return userVerif;
	}
}
