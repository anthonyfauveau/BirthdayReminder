package fr.anthony.birthdayReminder.dto;

import java.time.LocalDate;



public class BirthdayDTO {

	private Long userId;
	private LocalDate date;
	private String firstname;
	private String lastname;
	

	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Long getUserId() {
		return userId;
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
	
	
}
