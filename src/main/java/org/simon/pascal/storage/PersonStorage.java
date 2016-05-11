package org.simon.pascal.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.simon.pascal.model.Person;
import org.simon.pascal.repositories.PersonRepository;
import org.simon.pascal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

@Component 
public class PersonStorage {
	private static final String[] NOMS={"Nana","Ngos","Bibi","Moudou","Boula"};
	private static final String[] PRENOMS={"Pascal","Robert","Audrey","Gabriel"};
  
 @Autowired
 private PersonService personService;
  
  @PostConstruct
  public void init(){
	  final boolean isEmpty=personService.isEmpty();
	  if(isEmpty){
		  for(int i=0;i<11;i++){
			  final int randNom=((int) (Math.random()*195))%4;
			  final String nom=NOMS[randNom];
			  final int randPrenom=((int) (Math.random()*67))%3;
			  final String prenom=PRENOMS[randPrenom];
			  final int randPrenom2=((int) (Math.random()*111))%3;
			  final String prenom2=PRENOMS[randPrenom2];
			  
			  final int age=(int) (Math.random()*99)+1;
			  final Person person=new Person(null,nom, prenom+" "+prenom2, age);
			  personService.save(person);
		  }  
	  } 
  }
  
  public Collection<Person> getPersons(){
	  return personService.getPersons();
  }
  
  public Person ajouter(Person person){	  
	  return personService.save(person);
  }
  
  public Person modifier(Person person){
	  final Optional<Person> old=personService.findById(person.getId());
	  if(!old.isPresent()){
		  throw new IllegalArgumentException("L'ID ne doit pas etre null");
	  }
	  
	  final Person oldPerson=old.get();
	  if(!Strings.isNullOrEmpty(person.getNom())){
		  oldPerson.setNom(person.getNom());
	  }
	  if(!Strings.isNullOrEmpty(person.getPrenom())){
		  oldPerson.setPrenom(person.getPrenom());
	  }
	  oldPerson.setAge(person.getAge());
	  personService.modifier(oldPerson);
	  return oldPerson;
  }
  
  public void supprimer(Person person){
	  final Optional<Person> old=personService.findById(person.getId());
	  if(!old.isPresent()){
		  throw new IllegalArgumentException("L'ID ne doit pas etre null");
	  }
	  personService.supprimer(person.getId());	  
  }

public Person getPerson(long id) {	
	final Optional<Person> old=personService.findById(id);
	  if(!old.isPresent()){
		  throw new IllegalArgumentException("L'ID ne doit pas etre null");
	  }
	  return old.get();
}
  
}
