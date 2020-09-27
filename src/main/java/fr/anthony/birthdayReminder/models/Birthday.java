package fr.anthony.birthdayReminder.models;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "birthday_table")
public class Birthday {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private String firstname;
	private String lastname;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Birthday() {
		super();
	}

	public Birthday(Long id, LocalDate date, String firstname, String lastname, User user) {
		super();
		this.id = id;
		this.date = date;
		this.firstname = firstname;
		this.lastname = lastname;
		this.user = user;
	}

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Birthday [id=" + id + ", date=" + date + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", user=" + user + "]";
	}

}