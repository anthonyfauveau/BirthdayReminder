package fr.anthony.birthdayReminder.services;

import java.util.List;
import java.util.Optional;

import fr.anthony.birthdayReminder.models.User;


public interface UserService {
	
	public Optional<User>login(String email, String password);
	public List<User> getAllUsers();
	public User save(User user);
}
