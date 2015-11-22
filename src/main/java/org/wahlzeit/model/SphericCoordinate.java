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
		assertClassInvariants();
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
		assertOtherNotNull(other);
		setLatitude(other.getLatitude());
		setLongitude(other.getLongitude());
		setRadius(other.getRadius());
		assertClassInvariants();
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
		assertLatitudeValid(latitude);
		this.latitude = latitude;
		assertClassInvariants();
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
		assertLongitudeValid(longitude);
		this.longitude = longitude;
		assertClassInvariants();
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
		assertRadiusValid(radius);
		this.radius = radius;
		assertClassInvariants();
	}
	
	
	/**
	 * @methodtype query
	 */
	public double getLatitudinalDistance(SphericCoordinate other) {
		assertOtherNotNull(other);
		return Math.abs(latitude - other.latitude);
	}
	
	
	/**
	 * @methodtype query
	 */
	public double getLongitudinalDistance(SphericCoordinate other) {
		assertOtherNotNull(other);
		return Math.abs(longitude - other.longitude);
	}
	
	
	/**
	 * @methodtype conversion
	 */
	public String asString() {
		return "SphericCoordinate(" + radius + ", " + latitude + ", " + longitude + ")";
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() {
		assertLatitudeValid(latitude);
		assertLongitudeValid(longitude);
		assertRadiusValid(radius);
	}
	
}
