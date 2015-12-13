package org.wahlzeit.model;

import java.io.Serializable;

public interface Coordinate extends Serializable {

	/**
	 * @methodtype query
	 */
	double getDistance(Coordinate other);

	/**
	 * @methodtype comparison
	 */
	boolean isEqual(Coordinate other);
	
	/**
	 * @methodtype get
	 */
	public abstract double getLatitude();
	
	/**
	 * @methodtype set
	 */
	public abstract Coordinate setLatitude(double latitude);
	
	/**
	 * @methodtype get
	 */
	public abstract double getLongitude();
	
	/**
	 * @methodtype set
	 */
	public abstract Coordinate setLongitude(double longitude);
	
	/**
	 * @methodtype get
	 */
	public abstract double getRadius();
	
	/**
	 * @methodtype set
	 */
	public abstract Coordinate setRadius(double radius);

}