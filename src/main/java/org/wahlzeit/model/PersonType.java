package org.wahlzeit.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class PersonType implements Serializable {

	private static final long serialVersionUID = 1472227799041240108L;
	
	private final PersonType superType;
	@Id
	private final String profession;
	
	
	public PersonType(PersonType superType, String profession) {
		this.superType = superType;
		this.profession = profession;
	}
	
	
	/**
	 * @methodtype construct
	 */
	public Person createInstance(String name) {
		return new Person(this, name);
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
