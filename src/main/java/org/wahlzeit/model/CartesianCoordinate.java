package org.wahlzeit.model;

import java.io.Serializable;

public class CartesianCoordinate extends AbstractCoordinate implements Serializable {


	private static final long serialVersionUID = 5147685088635698410L;
	
	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate() {
		// empty
	}
	
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		doUpdateFromSpheric(other.getLatitude(), other.getLongitude(), other.getRadius());
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

	
	/**
	 * @methodtype basic
	 */
	private void doUpdateFromSpheric(double latitude, double longitude, double radius) {
		double rlat = Math.toRadians(latitude);
		double rlong = Math.toRadians(longitude);
		double r = radius;
		x = r * Math.sin(rlat) * Math.cos(rlong);
		y = r * Math.sin(rlat) * Math.sin(rlong);
		z = r * Math.cos(rlat);
	}
	

	/**
	 * @methodtype get
	 */
	@Override
	public double getLatitude() {
		double px = Math.pow(x, 2);
		double py = Math.pow(y, 2);
		double pz = Math.pow(z, 2);
		if (px + py + pz == 0) return 0;
		return Math.toDegrees(Math.acos(z / Math.sqrt(px + py + pz)));
	}
	
	
	/**
	 * @methodtype set
	 */
	@Override
	public void setLatitude(double latitude) {
		doUpdateFromSpheric(latitude, getLongitude(), getRadius());
		
	}


	/**
	 * @methodtype get
	 */
	@Override
	public double getLongitude() {
		double px = Math.pow(x, 2);
		double py = Math.pow(y, 2);
		if (px + py == 0) return 0;
		return Math.toDegrees(Math.acos(x / Math.sqrt(px + py)));
	}

	
	/**
	 * @methodtype set
	 */
	@Override
	public void setLongitude(double longitude) {
		doUpdateFromSpheric(getLatitude(), longitude, getRadius());
	}
	

	/**
	 * @methodtype get
	 */
	@Override
	public double getRadius() {
		double px = Math.pow(x, 2);
		double py = Math.pow(y, 2);
		double pz = Math.pow(z, 2);
		return Math.sqrt(px + py + pz);
	}


	/**
	 * @methodtype set
	 */
	@Override
	public void setRadius(double radius) {
		doUpdateFromSpheric(getLatitude(), getLongitude(), radius);
	}

}
