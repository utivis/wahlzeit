package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	private static final long serialVersionUID = -5649550494679485718L;
	
	private final PersonType type;
	private Date dateOfBirth;
	private Location placeOfBirth;
	private Date dateOfDeath;
	private Location placeOfDeath;
	private String knownFor = "nothing";
	
	
	public Person(PersonType type) {
		this.type = type;
	}
	
	
	public PersonType getType() {
		return type;
	}
	
	
	/**
	 * @methodtype get
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	
	/**
	 * @methodtype set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	/**
	 * @methodtype get
	 */
	public Location getPlaceOfBirth() {
		return placeOfBirth;
	}

	
	/**
	 * @methodtype set
	 */
	public void setPlaceOfBirth(Location placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	
	/**
	 * @methodtype get
	 */
	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	
	/**
	 * @methodtype set
	 */
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	
	/**
	 * @methodtype get
	 */
	public Location getPlaceOfDeath() {
		return placeOfDeath;
	}

	
	/**
	 * @methodtype set
	 */
	public void setPlaceOfDeath(Location placeOfDeath) {
		this.placeOfDeath = placeOfDeath;
	}


	/**
	 * @methodtype get
	 */
	public String getKnownFor() {
		return knownFor;
	}

	
	/**
	 * @methodtype set
	 */
	public void setKnownFor(String knownFor) {
		this.knownFor = knownFor;
	}

}
