package fr.anthony.birthdayReminder.controlers;



import java.net.URISyntaxException;
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
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private BirthdayRepository birthdayrepository;
	
	@GetMapping(value = { "", "/" })
	public List<User> getUsers() {
		return userservice.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") Long id) {
		  for(User oneUser : userservice.getAllUsers()) {
			  if(oneUser.getId().equals(id)) {
				  return oneUser;
			  }
		  }
		  return null;
	}
	
	@PostMapping(value = "/createusers", produces = APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		
		return userrepository.save(user);
	}
	
	@PutMapping(value= "/{userId}", produces = APPLICATION_JSON_VALUE)
	public void UpdateUser(@PathVariable Long userId, @RequestBody User user) throws Exception{
		Optional<User> userOptional = userrepository.findById(userId);
		if(!userOptional.isPresent()) {
			throw new Exception();
		}else {
			User userChanger = userrepository.findById(userId).get();
			userChanger.setUsername(user.getUsername());
			userChanger.setEmail(user.getEmail());
			userChanger.setPassword(user.getPassword());
			
			userrepository.save(userChanger);
		}
		
	}
	
	@DeleteMapping(value= "/{userId}", produces = APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable Long userId) throws Exception{
		Optional<User> userOptional = userrepository.findById(userId);
		if(!userOptional.isPresent()) {
			throw new Exception();
		}else {
			userrepository.deleteById(userId);
		}
		
	}
	
	
	@GetMapping("/{userId}/birthdays")
	public List<Birthday> getBirthdayByUserId(@PathVariable("userId") Long id) {
		List<Birthday>birthdayList = new ArrayList();
		
		  for(User oneUser : userservice.getAllUsers()) {
			  if(oneUser.getId().equals(id)) {
				  birthdayList.addAll(oneUser.getBirthdays());
				  return birthdayList;
			  }
		  }
		  return null;
	}

	
	@PostMapping(value = "/createbirthday", produces = APPLICATION_JSON_VALUE)
	public Birthday createBirthdays(@RequestBody BirthdayDTO birthdayDTO) throws URISyntaxException {
		
		Optional<User> user = userrepository.findById(birthdayDTO.getUserId());
		
		Birthday birthday = new Birthday();
		birthday.setFirstname(birthdayDTO.getFirstname());
		birthday.setLastname(birthdayDTO.getLastname());
		birthday.setDate(birthdayDTO.getDate());
		birthday.setUser(user.get());
		
		return birthdayrepository.save(birthday);
	}
	
	
	@PutMapping(value= "updatebirthday/{birthdayId}", produces = APPLICATION_JSON_VALUE)
	public void UpdateBirthday(@PathVariable Long birthdayId, @RequestBody Birthday birthday) throws Exception{
		Optional<Birthday> birthdayOptional = birthdayrepository.findById(birthdayId);
		if(!birthdayOptional.isPresent()) {
			throw new Exception();
		}else {
			Birthday birthdayChanger = birthdayrepository.findById(birthdayId).get();
			
			birthdayChanger.setFirstname(birthday.getFirstname());
			birthdayChanger.setLastname(birthday.getLastname());
			birthdayChanger.setDate(birthday.getDate());
			
			birthdayrepository.save(birthdayChanger);
		}
		
	}
	
	
	@DeleteMapping(value= "deletebirthday/{birthdayId}", produces = APPLICATION_JSON_VALUE)
	public void deleteBirthday(@PathVariable Long birthdayId) throws Exception{
		Optional<Birthday> birthdayOptional = birthdayrepository.findById(birthdayId);
		if(!birthdayOptional.isPresent()) {
			throw new Exception();
		}else {
			birthdayrepository.deleteById(birthdayId);
		}
		
	}
	
}
