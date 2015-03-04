package com.example.equation2ndgrade.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.example.equation2ndgrade.QuadraticEquation;

/**
 * Simple test case. Tests class that does not depend on the Android API.
 * @author bzafiris
 *
 */
public class QuadraticEquationTest extends TestCase {

	public void testAEinaiMiden() {
		try {
			QuadraticEquation equation = new QuadraticEquation(0, 1, 1);
			double[] sol = equation.solution();
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("Expected IllegalArgumentException ");
		
	}

	public void testThetikiDiakrinousa() {
		QuadraticEquation equation = new QuadraticEquation(2, -10, 12);
		double[] solutions = equation.solution();
		Assert.assertEquals(2, solutions.length);
		Assert.assertTrue(hasSolution(solutions, 3));
		Assert.assertTrue(hasSolution(solutions, 2));
	}

	public void testMidenikiDiakrinousa() {
		QuadraticEquation equation = new QuadraticEquation(2, 4, 2);
		double[] solutions = equation.solution();
		Assert.assertEquals(1, solutions.length);
		Assert.assertTrue(hasSolution(solutions, -1));
	}

	public void testArnitikiDiakrinousa() {
		QuadraticEquation equation = new QuadraticEquation(3, -1, 1);
		Assert.assertNull(equation.solution());
	}

	private boolean hasSolution(double[] solutions, double solution) {
		for (int i = 0; i < solutions.length; i++) {
			if (Math.abs(solutions[i] - solution) < QuadraticEquation.Epsilon) {
				return true;
			}
		}

		return false;
	}
}
