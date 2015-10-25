package org.wahlzeit.model;

import java.io.Serializable;

public class Coordinate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853691751849512975L;
	
	/*
	 * 
	 */
	private double latitude = 0;
	private double longitude = 0;
	
	
	public Coordinate() {
		// empty constructor
	}
	
	
	public Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public Coordinate(Coordinate other) {
		this.latitude = other.latitude;
		this.longitude = other.longitude;
	}
	
	
	public double getLatitude() {
		return latitude;
	}
	
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
	public double getLongitude() {
		return longitude;
	}
	
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	public Coordinate getDistance(Coordinate other) {
		return new Coordinate(getLatitudinalDistance(other), getLongitudinalDistance(other));
	}
	
	
	public double getLatitudinalDistance(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		return Math.abs(latitude - other.latitude);
	}
	
	
	public double getLongitudinalDistance(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		return Math.abs(longitude - other.longitude);
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		else if (this == other) return true;
		else if (other instanceof Coordinate) {
			if (((Coordinate) other).latitude == this.latitude
					&& ((Coordinate) other).longitude == this.longitude) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Coordinate(" + latitude + ", " + longitude + ")";
	}
	
}
