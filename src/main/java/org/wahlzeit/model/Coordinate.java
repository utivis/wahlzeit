package org.wahlzeit.model;

import java.io.Serializable;

public interface Coordinate extends Serializable {

	/**
	 * @methodtype query
	 */
	double getDistance(Coordinate other);

	/**
	 * @methodtype comparison
	 */
	boolean isEqual(Coordinate other);

}