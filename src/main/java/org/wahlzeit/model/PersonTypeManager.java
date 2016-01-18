package org.wahlzeit.model;

import java.util.HashMap;

import org.wahlzeit.services.ObjectManager;

public class PersonTypeManager extends ObjectManager {

	private final HashMap<String, PersonType> personTypes = new HashMap<>();
	
	private static PersonTypeManager instance = null;
	
	
	private PersonTypeManager() {
		// empty
	}
	
	
	public static synchronized PersonTypeManager getInstance() {
		if (instance == null) {
			instance = new PersonTypeManager();
		}
		return instance;
	}
	
	
	public PersonType getPersonType(String profession) {
		synchronized (personTypes) {
			if (personTypes.containsValue(profession)) {
				return personTypes.get(profession);
			} else {
				return null;
			}
		}
	}
	
	
	private void doAddPersonType(PersonType personType) {
		synchronized (personTypes) {
			if (personTypes.containsValue(personType.getProfession())) {
				throw new IllegalArgumentException("Person " + personType.getProfession() + " already existant.");
			}
			personTypes.put(personType.getProfession(), personType);
		}
	}
	
	
	public void addPersonType(PersonType personType) {
		doAddPersonType(personType);
	}
	
	
	public PersonType createPersonType(PersonType superType, String profession) {
		PersonType personType = PersonTypeFactory.getInstance().createPersonType(superType, profession);
		doAddPersonType(personType);
		return personType;
	}
	
	
	private void loadPersonTypes() {
		// TODO use super class methods to load persons via objectify
	}
	
	
	private void savePersonType(PersonType person) {
		// TODO use super class methods to save person via objectify
	}
	
	
	public void init() {
		loadPersonTypes();
	}

}
