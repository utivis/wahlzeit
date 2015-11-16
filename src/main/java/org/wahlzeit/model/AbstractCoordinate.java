package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	private static final long serialVersionUID = 1L;
	private static final double DELTA = 0.0001;

	
	/**
	 * @methodtype query
	 */
	@Override
	public double getDistance(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("Other coordiante cannot be null.");
		
		if (Math.abs(getRadius() - other.getRadius()) >= DELTA)
			throw new IllegalArgumentException("Cannot calculate distance - the two points are not located on the same sphere.");
		
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
	

}
