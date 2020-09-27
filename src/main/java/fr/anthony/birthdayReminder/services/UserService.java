package fr.anthony.birthdayReminder.services;

import java.util.List;


import fr.anthony.birthdayReminder.models.User;


public interface UserService {

	public User login(String username, String password);

	public List<User> getAllUsers();

	public User getUserById(Long id);

	public User save(User user);

}