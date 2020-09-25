package fr.anthony.birthdayReminder.services;

import java.util.List;


import fr.anthony.birthdayReminder.models.Birthday;


public interface BirthdayService {
	
	public List<Birthday> getAllBirthdays();
	public List<Birthday> getBirthdaysByUserId(Long userId);
	public Birthday save(Birthday birthday);
}
