package org.wahlzeit.model;

import java.io.Serializable;

public class PersonType implements Serializable {

	private static final long serialVersionUID = 1472227799041240108L;
	
	private final PersonType superType;
	private final String profession;
	
	
	public PersonType(PersonType superType, String profession) {
		this.superType = superType;
		this.profession = profession;
	}
	
	
	/**
	 * @methodtype construct
	 */
	public Person createInstance() {
		return new Person(this);
	}
	
	
	/**
	 * @methodtype get
	 */
	public PersonType getSuperType() {
		return superType;
	}
	
	
	/**
	 * @methodtype get
	 */
	public String getProfession() {
		return profession;
	}

}
