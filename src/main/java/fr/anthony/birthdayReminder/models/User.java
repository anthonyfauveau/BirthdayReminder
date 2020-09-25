package fr.anthony.birthdayReminder.models;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "user_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="user")
	private Set<Birthday> birthdays;
	
	public Set<Birthday> getBirthdays() {
		return birthdays;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
		
	}

	public User(Long pId, String pUsername, String pEmail, String pPassword) {
		super();
		id = pId; 
		username = pUsername;
		email = pEmail;
		password =pPassword;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	
	
	
}
