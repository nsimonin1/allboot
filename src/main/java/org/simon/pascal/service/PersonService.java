package org.simon.pascal.service;

import java.util.List;
import java.util.Optional;

import org.simon.pascal.model.Person;

public interface PersonService {
	Person save(Person person);
	List<Person> getPersons();	
	boolean isEmpty();
	Optional<Person> findById(Long id);
	void modifier(Person oldPerson);
	void supprimer(Long id);

}
