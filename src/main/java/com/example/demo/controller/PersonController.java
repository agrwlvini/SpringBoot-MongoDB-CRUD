package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	@RequestMapping("/create")
	public String create(@RequestParam String id,@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
		System.out.println("first "+firstName +"last "+lastName);
		Person p=personService.create(id,firstName,lastName,age);
		return p.toString();
	}
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String firstName) {
		return personService.getByFirstName(firstName);
	}
	@RequestMapping("/getAll")
	public List<Person> getAll() {
		return personService.getAll();
	}
	@RequestMapping("/update")
	public String update(@RequestParam String id,@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
		Person p=personService.update(id,firstName,lastName,age);
		return p.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String id) {
		personService.delete(id);//(personService.getByFirstName(firstName));
		return "Deleted "+id;
	}
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		return "Deleted all records";
	}
}


