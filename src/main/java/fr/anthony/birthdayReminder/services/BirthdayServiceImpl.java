package fr.anthony.birthdayReminder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.anthony.birthdayReminder.models.Birthday;
import fr.anthony.birthdayReminder.repositories.BirthdayRepository;

@Service("Birthdays")
public class BirthdayServiceImpl implements BirthdayService{

	@Autowired
	private BirthdayRepository birthdayRepository;
	

	@Override
	public List<Birthday> getAllBirthdays() {
		return (List<Birthday>) birthdayRepository.findAll();
	}

	@Override
	public List<Birthday> getBirthdaysByUserId(Long userId) {
		
	List<Birthday> result = new ArrayList<>();
		
		for (Birthday birthday : birthdayRepository.findAll()) {
			if(birthday.getId() == userId)
				result.add(birthday);
		}
		
		return result;
	}

	@Override
	public Birthday save(Birthday birthday) {
		birthdayRepository.save(birthday);
		return birthday;
	}
}
