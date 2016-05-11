package org.simon.pascal.repositories;

import java.util.Optional;

import org.simon.pascal.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

	Optional<Person> findOneById(Long id);

}

