package org.simon.pascal.service.impl;

import java.util.List;
import java.util.Optional;

import org.simon.pascal.model.Person;
import org.simon.pascal.repositories.PersonRepository;
import org.simon.pascal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PersonServiceImp implements PersonService {
	 @Autowired
	 private PersonRepository personRepository;
	 
	 public Person save(Person person){
		return personRepository.save(person); 
	 }
	 
	 public List<Person> getPersons(){
		 return personRepository.findAll();
	 }

	@Override
	public boolean isEmpty() {		 
		return personRepository.count()==0;
	}

	@Override
	public Optional<Person> findById(Long id) {		 
		return personRepository.findOneById(id);
	}

	@Override
	public void modifier(Person person) {
		personRepository.save(person);
		
	}

	@Override
	public void supprimer(Long id) {
		personRepository.delete(id); 		
	}
}
