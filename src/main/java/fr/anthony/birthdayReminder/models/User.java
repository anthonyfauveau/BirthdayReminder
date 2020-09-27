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

	@OneToMany(mappedBy = "user")
	private Set<Birthday> birthdays;

	public User() {
		super();
	}

	public User(Long id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Set<Birthday> getBirthdays() {
		//birthdays.removeIf(b -> b.getLastName().equals("Bardu") || b.getLastName().equals("Leveque"));
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

	// public Set<Birthday> getBirthdays() {
	// return birthdays;
	// }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}

}