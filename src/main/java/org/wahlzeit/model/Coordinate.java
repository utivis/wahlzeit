package org.wahlzeit.model;

import java.io.Serializable;

public class Coordinate implements Serializable {

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
	
	
	public Coordinate() {
		// empty constructor
	}
	
	
	public Coordinate(double latitude, double longitude) {
		setLatitude(latitude);
		setLongitude(longitude);
	}
	
	
	public Coordinate(Coordinate other) {
		this.latitude = other.latitude;
		this.longitude = other.longitude;
	}
	
	
	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}
	
	
	/**
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}
	
	
	/**
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	public double getDistance(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		double rlat1 = Math.toRadians(latitude);
		double rlat2 = Math.toRadians(other.latitude);
		double rlongdiff = Math.toRadians(getLongitudinalDistance(other));
		double c = Math.acos(Math.sin(rlat1) * Math.sin(rlat2) + Math.cos(rlat1) * Math.cos(rlat2) * Math.cos(rlongdiff));
		return EARTH_RADIUS_KM * c;
	}
	
	
	public double getLatitudinalDistance(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		return Math.abs(latitude - other.latitude);
	}
	
	
	public double getLongitudinalDistance(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		return Math.abs(longitude - other.longitude);
	}
	
	
	/**
	 * @methodtype comparison
	 */
	public boolean isEqual(Coordinate other) {
		return (other != null) && latitude == other.latitude && longitude == other.longitude;
	}
	
	
	/**
	 * @methodtype comparison
	 */
	@Override
	public boolean equals(Object other) {
		return (other instanceof Coordinate) && isEqual((Coordinate)other);
	}
	
	
	/**
	 * @methodtype conversion
	 */
	public String asString() {
		return "Coordinate(" + latitude + ", " + longitude + ")";
	}
	
}
