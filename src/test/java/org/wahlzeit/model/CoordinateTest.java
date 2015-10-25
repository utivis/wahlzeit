package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	
	private Coordinate c1, c2, c3, c4, c5;

	@Before
	public void setUp() {
		c1 = new Coordinate(0, 0);
		c2 = new Coordinate(10, 10);
		c3 = new Coordinate(25, 0);
		c4 = new Coordinate(145, -84);
		c5 = new Coordinate(-2, -105);
	}

	@Test
	public void testGetLatitudinalDistance() {
		assertTrue(c1.getLatitudinalDistance(c2) == 10);
		assertTrue(c2.getLatitudinalDistance(c3) == 15);
		assertTrue(c3.getLatitudinalDistance(c4) == 120);
		assertTrue(c4.getLatitudinalDistance(c5) == 147);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetLatitudinalDistanceOnNullArgument() {
		c1.getLatitudinalDistance(null);
	}

	@Test
	public void testGetLongitudinalDistance() {
		assertTrue(c1.getLongitudinalDistance(c2) == 10);
		assertTrue(c2.getLongitudinalDistance(c3) == 10);
		assertTrue(c3.getLongitudinalDistance(c4) == 84);
		assertTrue(c4.getLongitudinalDistance(c5) == 21);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetLongitudinalDistanceOnNullArgument() {
		c1.getLongitudinalDistance(null);
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(c1.getDistance(c2), new Coordinate(10, 10));
		assertEquals(c2.getDistance(c3), new Coordinate(15, 10));
		assertEquals(c3.getDistance(c4), new Coordinate(120, 84));
		assertEquals(c4.getDistance(c5), new Coordinate(147, 21));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceOnNullArgument() {
		c1.getDistance(null);
	}

	@Test
	public void testEqualsObject() {
		assertFalse(c1.equals(null));
		assertFalse(c1.equals(c2));
		assertFalse(c3.equals(c4));
		assertFalse(c4.equals(c5));
		assertTrue(c1.equals(new Coordinate(c1)));
		assertTrue(c2.equals(new Coordinate(c2)));
		assertTrue(c3.equals(new Coordinate(c3)));
		assertTrue(c4.equals(new Coordinate(c4)));
		assertTrue(c5.equals(new Coordinate(c5)));
	}

}
