package fr.anthony.birthdayReminder.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.anthony.birthdayReminder.models.User;
import fr.anthony.birthdayReminder.repositories.UserRepository;

@Service("users")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;


	@Override
	public Optional<User> login(String username, String password){
		
		return userRepository.login(username,password);
		
	}        
	
	@Override
	public List<User> getAllUsers() {
		
		return (List<User>) userRepository.findAll(); 
	}
     
	@Override
	public User save(User user) {
		userRepository.save(user);
		return user;
	}

}
