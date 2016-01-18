package org.wahlzeit.model;

import java.util.HashMap;

import org.wahlzeit.services.ObjectManager;

public class PersonManager extends ObjectManager {
	
	private final HashMap<String, Person> persons = new HashMap<>();
	
	private static PersonManager instance = null;
	
	
	private PersonManager() {
		// empty
	}
	
	
	public synchronized PersonManager getInstance() {
		if (instance == null) {
			instance = new PersonManager();
		}
		return instance;
	}
	
	
	public Person getPerson(String name) {
		synchronized (persons) {
			if (persons.containsValue(name)) {
				return persons.get(name);
			} else {
				return null;
			}
		}
	}
	
	
	public void addPerson(Person person) {
		synchronized (persons) {
			if (persons.containsValue(person.getName())) {
				throw new IllegalArgumentException("Person " + person.getName() + " already existant.");
			}
			persons.put(person.getName(), person);
		}
	}
	
	
	private void loadPersons() {
		// TODO use super class methods to load persons via objectify
	}
	
	
	private void savePerson(Person person) {
		// TODO use super class methods to save person via objectify
	}
	
	
	public void init() {
		loadPersons();
	}

}
