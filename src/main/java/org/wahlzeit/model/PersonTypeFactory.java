package org.wahlzeit.model;

public class PersonTypeFactory {

	private static PersonTypeFactory instance = null;
	
	
	private PersonTypeFactory() {
		// empty
	}
	
	
	public synchronized PersonTypeFactory getInstance() {
		if (instance == null) {
			instance = new PersonTypeFactory();
		}
		return instance;
	}
	
	
	public PersonType createPersonType(PersonType superType, String profession) {
		return new PersonType(superType, profession);
	}
	
	
	public PersonType createPersonType(String profession) {
		return createPersonType(null, profession);
	}
	
}
