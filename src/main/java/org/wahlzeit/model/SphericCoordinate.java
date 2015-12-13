package org.wahlzeit.model;

import java.io.Serializable;
import java.util.HashMap;

public class SphericCoordinate extends AbstractCoordinate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853691751849512975L;
	private static final double EARTH_RADIUS_KM = 6378.137;
	
	private static HashMap<SphericCoordinate, SphericCoordinate> instances = new HashMap<>();
	
	/*
	 * 
	 */
	private final double latitude;
	private final double longitude;
	private final double radius;
	
	
	/**
	 * @methodtype constructor
	 */
	private SphericCoordinate(double latitude, double longitude, double radius) {
		assertLatitudeValid(latitude);
		assertLongitudeValid(longitude);
		assertRadiusValid(radius);
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		assertClassInvariants();
	}
	
	
	/**
	 * @methodtype creation method
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude, double radius) {
		SphericCoordinate tmp = new SphericCoordinate(latitude, longitude, radius);
		synchronized (instances) {
			if (instances.containsKey(tmp)) {
				return instances.get(tmp);
			} else {
				instances.put(tmp, tmp);
				return tmp;
			}
		}
	}
	
	
	/**
	 * @methodtype creation method
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude) {
		return getInstance(latitude, longitude, EARTH_RADIUS_KM);
	}
	
	
	/**
	 * @methodtype creation method
	 */
	public static SphericCoordinate getInstance(Coordinate other) {
		assertOtherNotNull(other);
		return getInstance(other.getLatitude(), other.getLongitude(), other.getRadius());
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
	public Coordinate setLatitude(double latitude) {
		return new SphericCoordinate(latitude, this.longitude, this.radius);
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
	public Coordinate setLongitude(double longitude) {
		return new SphericCoordinate(this.latitude, longitude, this.radius);
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
	public Coordinate setRadius(double radius) {
		return new SphericCoordinate(this.latitude, this.longitude, radius);
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SphericCoordinate other = (SphericCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	
}
