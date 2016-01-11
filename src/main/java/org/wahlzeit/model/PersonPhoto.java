package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index = true)
public class PersonPhoto extends Photo {
	
	private static final long serialVersionUID = 7021885354590441181L;
	
	private Person person;
	
	
	public PersonPhoto() {
		super();
	}

	
	public PersonPhoto(PhotoId myId) {
		super(myId);
	}

	
	/**
	 * @methodtype get
	 */
	public Person getPerson() {
		return person;
	}

	
	/**
	 * @methodtype set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

}
