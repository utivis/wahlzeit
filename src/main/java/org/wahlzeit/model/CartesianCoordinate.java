package org.wahlzeit.model;

import java.io.Serializable;
import java.util.HashMap;

public class CartesianCoordinate extends AbstractCoordinate implements Serializable {


	private static final long serialVersionUID = 5147685088635698410L;
	
	private static HashMap<CartesianCoordinate, CartesianCoordinate> instances = new HashMap<>();
	
	
	private final double x;
	private final double y;
	private final double z;
	
	
	/**
	 * @methodtype constructor
	 */
	private CartesianCoordinate(double x, double y, double z) {
		assertXValid(x);
		assertYValid(y);
		assertZValid(z);
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
	}
	
	
	/**
	 * @methodtype creation method
	 */
	public static CartesianCoordinate getInstance(double x, double y, double z) {
		CartesianCoordinate tmp = new CartesianCoordinate(x, y, z);
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
	 * @methodtype constructor
	 */
	public static CartesianCoordinate getInstance(Coordinate other) {
		assertOtherNotNull(other);
		assertLatitudeValid(other.getLatitude());
		assertLongitudeValid(other.getLongitude());
		assertRadiusValid(other.getRadius());
		CartesianCoordinate c;
		if (other instanceof CartesianCoordinate) {
			c = (CartesianCoordinate)other;
		} else {
			c = doCreateFromSpheric(other.getLatitude(), other.getLongitude(), other.getRadius());
		}
		return getInstance(c.x, c.y, c.z);
	}
	
	
	/**
	 * @methodtype basic
	 */
	private static CartesianCoordinate doCreateFromSpheric(double latitude, double longitude, double radius) {
		double rlat = Math.toRadians(latitude);
		double rlong = Math.toRadians(longitude);
		double r = radius;
		double newX = r * Math.sin(rlat) * Math.cos(rlong);
		double newY = r * Math.sin(rlat) * Math.sin(rlong);
		double newZ = r * Math.cos(rlat);
		return new CartesianCoordinate(newX, newY, newZ);
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
	public Coordinate setX(double x) {
		return getInstance(x, this.y, this.z);
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
	public Coordinate setY(double y) {
		return getInstance(this.x, y, this.z);
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
	public Coordinate setZ(double z) {
		return getInstance(this.x, this.y, z);
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
	public Coordinate setLatitude(double latitude) {
		return getInstance(doCreateFromSpheric(latitude, this.getLongitude(), this.getRadius()));
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
	public Coordinate setLongitude(double longitude) {
		return getInstance(doCreateFromSpheric(this.getLatitude(), longitude, this.getRadius()));
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
	public Coordinate setRadius(double radius) {
		return getInstance(doCreateFromSpheric(this.getLatitude(), this.getLongitude(), radius));
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() {
		assertXValid(x);
		assertYValid(y);
		assertZValid(z);
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected void assertXValid(double x) {
		assert !Double.isNaN(x);
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected void assertYValid(double y) {
		assert !Double.isNaN(y);
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected void assertZValid(double z) {
		assert !Double.isNaN(z);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
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
		CartesianCoordinate other = (CartesianCoordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

}
