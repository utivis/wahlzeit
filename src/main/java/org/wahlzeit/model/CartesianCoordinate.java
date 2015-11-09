package org.wahlzeit.model;

import java.io.Serializable;

public class CartesianCoordinate implements Serializable, Coordinate {


	private static final long serialVersionUID = 5147685088635698410L;
	private static final double DELTA = 0.0001;
	
	private double x;
	private double y;
	private double z;
	
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(Coordinate other) {
		if (other instanceof CartesianCoordinate)
			initializeFromCartesian((CartesianCoordinate)other);
		else if (other instanceof SphericCoordinate)
			intitializeFromSpheric((SphericCoordinate)other);
		else
			throw new IllegalArgumentException("Cannot convert from given object");
	}
	
	
	/**
	 * @methodtype initialization
	 * @param other
	 */
	private void initializeFromCartesian(CartesianCoordinate other) {
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
	}
	
	
	/**
	 * @methodtype initialization
	 * @param other
	 */
	private void intitializeFromSpheric(SphericCoordinate other) {
		double rlat = Math.toRadians(other.getLatitude());
		double rlong = Math.toRadians(other.getLongitude());
		x = other.getRadius() * Math.sin(rlat) * Math.cos(rlong);
		y = other.getRadius() * Math.sin(rlat) * Math.sin(rlong);
		z = other.getRadius() * Math.cos(rlat);
	}

	
	@Override
	public double getDistance(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		
		// Convert both coordinates to spheric in order to calculate the distance on the surface of a sphere.
		// (This would be very diffictult to achieve with cartesian coordinates..)
		SphericCoordinate sThis = new SphericCoordinate(this);
		SphericCoordinate sOther = new SphericCoordinate(other);
		return sThis.getDistance(sOther);
	}
	

	@Override
	public boolean isEqual(Coordinate other) {
		if (other == null) return false;
		CartesianCoordinate tmp = new CartesianCoordinate(other);
		return (Math.abs(x - tmp.x) < DELTA) && (Math.abs(y - tmp.y) < DELTA)
				&& (Math.abs(z - tmp.z) < DELTA);
	}
	
	
	/**
	 * @methodtype conversion
	 */
	public String asString() {
		return "CartesianCoordinate(" + x + ", " + y + ", " + z + ")";
	}


	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}


	/**
	 * @methodtype set
	 */
	public void setX(double x) {
		this.x = x;
	}


	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}


	/**
	 * @methodtype set
	 */
	public void setY(double y) {
		this.y = y;
	}


	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}


	/**
	 * @methodtype set
	 */
	public void setZ(double z) {
		this.z = z;
	}

}
