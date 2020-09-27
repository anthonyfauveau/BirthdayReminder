package fr.anthony.birthdayReminder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.anthony.birthdayReminder.exceptions.UserNotFoundException;
import fr.anthony.birthdayReminder.models.User;
import fr.anthony.birthdayReminder.repositories.UserRepository;

@Service("users")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String username, String password) {

		System.out.println("-----__> " + username);
		System.out.println("-----__> " + password);
		
		return userRepository.login(username, password).orElseThrow(() -> new UserNotFoundException());
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

}