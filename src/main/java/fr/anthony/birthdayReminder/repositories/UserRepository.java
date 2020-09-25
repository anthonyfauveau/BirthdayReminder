package fr.anthony.birthdayReminder.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.anthony.birthdayReminder.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

	@Query(value = "SELECT u FROM User u where u.email = ?1 and u.password = ?2 ")
	Optional<User> login(String email,String password);
		
}
