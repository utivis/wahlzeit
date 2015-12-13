package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	private static final long serialVersionUID = 1L;
	private static final double DELTA = 0.0001;

	
	/**
	 * @methodtype query
	 */
	@Override
	public double getDistance(Coordinate other) {
		assertOtherNotNull(other);
		assertIsOnSameSphere(other.getRadius());
		
		double rlat1 = Math.toRadians(getLatitude());
		double rlat2 = Math.toRadians(other.getLatitude());
		double rlongdiff = Math.toRadians(Math.abs(getLongitude() - other.getLongitude()));
		double c = Math.acos(Math.sin(rlat1) * Math.sin(rlat2) + Math.cos(rlat1) * Math.cos(rlat2) * Math.cos(rlongdiff));
		return getRadius() * c;
	}

	
	/**
	 * @methodtype comparison
	 */
	@Override
	public boolean isEqual(Coordinate other) {
		if (other == null) return false;
		return (Math.abs(getRadius() - other.getRadius()) < DELTA) && (Math.abs(getLatitude() - other.getLatitude()) < DELTA)
				&& ((getLatitude() == 0) || (Math.abs(getLongitude() - other.getLongitude()) < DELTA));
	}
	

	/**
	 * @methodtype assertion
	 */
	protected void assertIsOnSameSphere(double otherRadius) {
		if (Math.abs(getRadius() - otherRadius) >= DELTA)
			throw new IllegalArgumentException("Cannot calculate distance - the two points are not located on the same sphere.");
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertLatitudeValid(double latitude) {
		assert !Double.isNaN(latitude);
		if (latitude < -90 || latitude >= 90)
			throw new IllegalArgumentException("Latitude out of range (-90 to 90)");
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertLongitudeValid(double longitude) {
		assert !Double.isNaN(longitude);
		if (longitude < -180 || longitude >= 180)
			throw new IllegalArgumentException("Longitude out of range (-180 to 180)");
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertRadiusValid(double radius) {
		assert !Double.isNaN(radius);
		if (radius < 0)
			throw new IllegalArgumentException("Radius out of range (>= 0)");
	}
	
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertOtherNotNull(Coordinate other) {
		if (other == null)
			throw new IllegalArgumentException("Other coordiante cannot be null.");
	}
	
	public abstract int hashCode();
	
	public abstract boolean equals(Object obj);
	
}
