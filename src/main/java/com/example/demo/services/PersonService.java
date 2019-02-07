package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;


@Service
public class PersonService {

	@Autowired
	PersonRepository<Person> personRepository;

	@Transactional
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	public List<Person> findByName(String name) {
		return personRepository.findByFirstName(name);
	}
	
	public Person findByIdAndName(Long id,String name) {
		return personRepository.findByIdAndFirstName(id, name);
	}

	public Optional<Person> getById(Long id) {
		return personRepository.findById(id);
	}

	@Transactional
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}

	@Transactional
	public boolean addPerson(Person person) {
		return personRepository.save(person) != null;
	}

	@Transactional
	public boolean updatePerson(Person person) {
		Optional<Person> isperson = null;
		if(person != null && person.getId() != null) {
			 isperson = personRepository.findById(person.getId());
		}
		if(isperson.isPresent()) {
			return personRepository.save(person) != null;
		}
		return false;
		
	}
}

