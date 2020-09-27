package fr.anthony.birthdayReminder.services;

import java.util.List;


import fr.anthony.birthdayReminder.models.Birthday;



public interface BirthdayService {
	public List<Birthday> getAllBirthdays();
	
	public Birthday save(Birthday birthday);
}