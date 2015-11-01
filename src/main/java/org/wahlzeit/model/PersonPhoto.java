package org.wahlzeit.model;

import java.util.Date;

public class PersonPhoto extends Photo {
	
	private static final long serialVersionUID = 7021885354590441181L;
	
	private Date dateOfBirth;
	private Location placeOfBirth;
	private Date dateOfDeath;
	private Location placeOfDeath;
	private String field;
	private String knownFor;
	
	
	public PersonPhoto() {
		super();
	}

	
	public PersonPhoto(PhotoId myId) {
		super(myId);
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
	public String getField() {
		return field;
	}

	
	/**
	 * @methodtype set
	 */
	public void setField(String field) {
		this.field = field;
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
