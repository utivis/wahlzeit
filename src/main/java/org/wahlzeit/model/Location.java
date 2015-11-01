package org.wahlzeit.model;

import java.io.Serializable;

public class Location implements Serializable {

	private static final long serialVersionUID = -3646721611221841315L;
	
	private String name;
	private Coordinate coordinate;

	/**
	 * @methodtype get
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @methodtype set
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @methodtype get
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * @methodtype set
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
}
