package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	
	private final double DELTA = 0.1;
	private Coordinate sc1, sc2, sc3, sc4, cc1, cc2, cc3, cc4;

	@Before
	public void setUp() {
		sc1 = new SphericCoordinate(0, 0);
		sc2 = new SphericCoordinate(10, 10);
		sc3 = new SphericCoordinate(25, 0);
		sc4 = new SphericCoordinate(45, -84);
		cc1 = new CartesianCoordinate(sc1);
		cc2 = new CartesianCoordinate(sc2);
		cc3 = new CartesianCoordinate(sc3);
		cc4 = new CartesianCoordinate(sc4);
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(1570.28, sc1.getDistance(sc2), DELTA);
		assertEquals(1976.54, sc2.getDistance(sc3), DELTA);
		assertEquals(7630.03, sc3.getDistance(sc4), DELTA);
		
		assertEquals(1570.28, sc1.getDistance(cc2), DELTA);
		assertEquals(1976.54, sc2.getDistance(cc3), DELTA);
		assertEquals(7630.03, sc3.getDistance(cc4), DELTA);
		
		assertEquals(1570.28, cc1.getDistance(sc2), DELTA);
		assertEquals(1976.54, cc2.getDistance(sc3), DELTA);
		assertEquals(7630.03, cc3.getDistance(sc4), DELTA);
		
		assertEquals(1570.28, cc1.getDistance(cc2), DELTA);
		assertEquals(1976.54, cc2.getDistance(cc3), DELTA);
		assertEquals(7630.03, cc3.getDistance(cc4), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceOnNullArgument() {
		sc1.getDistance(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceOnNullArgument2() {
		assert false;
		cc1.getDistance(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceOfTwoPointsOnDifferentSpheres() {
		sc2.getDistance(new SphericCoordinate(1, 2, 3));
	}

	@Test
	public void testIsEqual() {
		assertFalse(sc1.isEqual(null));
		assertFalse(cc1.isEqual(null));
		assertFalse(sc1.isEqual(sc2));
		assertFalse(cc1.isEqual(cc2));
		assertFalse(sc1.isEqual(cc2));
		assertFalse(cc1.isEqual(sc2));
		
		assertTrue(sc1.isEqual(new SphericCoordinate(sc1)));
		assertTrue(cc2.isEqual(new CartesianCoordinate(cc2)));
		
		assertTrue(sc1.isEqual(cc1));
		assertTrue(sc3.isEqual(cc3));
		assertTrue(cc1.isEqual(sc1));
		assertTrue(cc3.isEqual(sc3));
	}

}
