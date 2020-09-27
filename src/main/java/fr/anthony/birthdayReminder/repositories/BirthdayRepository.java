package fr.anthony.birthdayReminder.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.anthony.birthdayReminder.models.Birthday;

public interface BirthdayRepository extends CrudRepository<Birthday, Long> {

}