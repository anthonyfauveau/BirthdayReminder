package fr.anthony.birthdayReminder.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.anthony.birthdayReminder.models.Birthday;
import fr.anthony.birthdayReminder.repositories.BirthdayRepository;

@Service("birthdays")
public class BirthdayServiceImpl implements BirthdayService {

	@Autowired
	private BirthdayRepository birthdayRepository;
	
	@Override
	public List<Birthday> getAllBirthdays() {
		
		return (List<Birthday>)birthdayRepository.findAll();
	}

	@Override
	public Birthday save(Birthday birthday) {

		return birthdayRepository.save(birthday);
	}


}
