package org.wahlzeit.model;

import java.io.Serializable;

public class SphericCoordinate implements Serializable, Coordinate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853691751849512975L;
	private static final double EARTH_RADIUS_KM = 6378.137;
	private static final double DELTA = 0.0001;
	
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
		if (other instanceof SphericCoordinate)
			intitializeFromSpheric((SphericCoordinate)other);
		else if (other instanceof CartesianCoordinate)
			initializeFromCartesian((CartesianCoordinate)other);
		else
			throw new IllegalArgumentException("Cannot convert from given object");
	}
	
	
	/**
	 * @methodtype initialization
	 * @param other
	 */
	private void intitializeFromSpheric(SphericCoordinate other) {
		this.latitude = other.latitude;
		this.longitude = other.longitude;
		this.radius = other.radius;
	}
	
	
	/**
	 * @methodtype initialization
	 * @param other
	 */
	private void initializeFromCartesian(CartesianCoordinate other) {
		/*latitude = Math.toDegrees(Math.atan(Math.sqrt(Math.pow(other.getX(), 2) + Math.pow(other.getY(), 2)) / other.getZ()));
		longitude = Math.toDegrees(Math.atan(other.getY() / other.getX()));
		radius = Math.sqrt(Math.pow(other.getX(), 2) + Math.pow(other.getY(), 2) + Math.pow(other.getZ(), 2));*/
		double x = other.getX();
		double y = other.getY();
		double z = other .getZ();
		double px = Math.pow(x, 2);
		double py = Math.pow(y, 2);
		double pz = Math.pow(z, 2);
		
		if (px + py + pz == 0) latitude = 0;
		else latitude = Math.toDegrees(Math.acos(z / Math.sqrt(px + py + pz)));
		if (px + py == 0) longitude = 0;
		else longitude = Math.toDegrees(Math.acos(x / Math.sqrt(px + py)));
		radius = Math.sqrt(px + py + pz);
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
		if (latitude < -180 || latitude > 180)
			throw new IllegalArgumentException("Latitude out of range (-90 to 90)");
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
		if (longitude < -180 || longitude > 180)
			throw new IllegalArgumentException("Longitude out of range (-180 to 180)");
		this.longitude = longitude;
	}
	
	
	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}


	/**
	 * @methodtype set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	@Override
	public double getDistance(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		
		SphericCoordinate tmp = new SphericCoordinate(other);
		
		if (Math.abs(radius - tmp.radius) >= DELTA)
			throw new IllegalArgumentException("Cannot calculate distance - the two points are not located on the same sphere.");
		
		double rlat1 = Math.toRadians(latitude);
		double rlat2 = Math.toRadians(tmp.latitude);
		double rlongdiff = Math.toRadians(getLongitudinalDistance(tmp));
		double c = Math.acos(Math.sin(rlat1) * Math.sin(rlat2) + Math.cos(rlat1) * Math.cos(rlat2) * Math.cos(rlongdiff));
		return radius * c;
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
	
	
	@Override
	public boolean isEqual(Coordinate other) {
		if (other == null) return false;
		SphericCoordinate tmp = new SphericCoordinate(other);
		return (Math.abs(radius - tmp.radius) < DELTA) && (Math.abs(latitude - tmp.latitude) < DELTA)
				&& ((latitude == 0) || (Math.abs(longitude - tmp.longitude) < DELTA));
	}
	
	
	/**
	 * @methodtype conversion
	 */
	public String asString() {
		return "SphericCoordinate(" + radius + ", " + latitude + ", " + longitude + ")";
	}
	
}
