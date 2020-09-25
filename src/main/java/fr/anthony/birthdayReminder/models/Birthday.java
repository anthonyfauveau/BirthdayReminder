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
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	private LocalDate date;
	private String firstname;
	private String lastname;
	
	
	public Long getId() {
		return id;
	}


	public LocalDate getDate() {
		return date;
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}



	public void setUser(User User) {
		this.user = User;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	@Override
	public String toString() {
		return "Birthday [id=" + id +", date=" + date + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}


	public Birthday() {
		super();
	}


	public Birthday(long pId, LocalDate pDate, String pFirstname, String pLastname,  User pUser) {
		id = pId;
		user = pUser;
		date = pDate;
		firstname = pFirstname;
		lastname = pLastname;
	}
}
