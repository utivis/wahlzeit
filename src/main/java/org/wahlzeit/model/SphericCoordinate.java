package org.wahlzeit.model;

import java.io.Serializable;

public class SphericCoordinate extends AbstractCoordinate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853691751849512975L;
	private static final double EARTH_RADIUS_KM = 6378.137;
	
	/*
	 * 
	 */
	private double latitude = 0;
	private double longitude = 0;
	private double radius = EARTH_RADIUS_KM;
	
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate() {
		// empty constructor
	}
	
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		setLatitude(latitude);
		setLongitude(longitude);
		setRadius(radius);
	}
	
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude) {
		this(latitude, longitude, EARTH_RADIUS_KM);
	}
	
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		setLatitude(other.getLatitude());
		setLongitude(other.getLongitude());
		setRadius(other.getRadius());
	}
	
	
	/**
	 * @methodtype get
	 */
	@Override
	public double getLatitude() {
		return latitude;
	}
	
	
	/**
	 * @methodtype set
	 */
	@Override
	public void setLatitude(double latitude) {
		if (latitude < -180 || latitude > 180)
			throw new IllegalArgumentException("Latitude out of range (-90 to 90)");
		this.latitude = latitude;
	}
	
	
	/**
	 * @methodtype get
	 */
	@Override
	public double getLongitude() {
		return longitude;
	}
	
	
	/**
	 * @methodtype set
	 */
	@Override
	public void setLongitude(double longitude) {
		if (longitude < -180 || longitude > 180)
			throw new IllegalArgumentException("Longitude out of range (-180 to 180)");
		this.longitude = longitude;
	}
	
	
	/**
	 * @methodtype get
	 */
	@Override
	public double getRadius() {
		return radius;
	}


	/**
	 * @methodtype set
	 */
	@Override
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	/**
	 * @methodtype query
	 */
	public double getLatitudinalDistance(SphericCoordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		return Math.abs(latitude - other.latitude);
	}
	
	
	/**
	 * @methodtype query
	 */
	public double getLongitudinalDistance(SphericCoordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		return Math.abs(longitude - other.longitude);
	}
	
	
	/**
	 * @methodtype conversion
	 */
	public String asString() {
		return "SphericCoordinate(" + radius + ", " + latitude + ", " + longitude + ")";
	}
	
}
