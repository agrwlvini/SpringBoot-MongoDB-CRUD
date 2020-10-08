package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	//Create Operation
	public Person create(String id,String firstName, String lastName, int age) {
		return personRepository.save(new Person(id,firstName,lastName,age));
	}
	//Retrieve Operation
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	//Update operation
	public Person update(String id,String firstName, String lastName, int age) {
		Person p=personRepository.findById(id).get();
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		System.out.print(firstName+" "+lastName+" "+age);
		return personRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public void delete(String id) {
		Person p=personRepository.findById(id).get();
		personRepository.delete(p);
	}
}

