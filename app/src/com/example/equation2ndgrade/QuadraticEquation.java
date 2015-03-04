package com.example.equation2ndgrade;



public class QuadraticEquation {
	public static final double Epsilon = 0.00001;
	
	private Integer a;
	private Integer b;
	private Integer c;
	
	
	public QuadraticEquation(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	
	public double[] solution() {
		if (a  == 0) {
			throw new IllegalArgumentException();
		}
		
		double diakrinousa = getDiscriminant();
		
		if (diakrinousa > Epsilon) {
			double[] solutions = new double[2];
			solutions[0] = (-b + Math.sqrt(diakrinousa)) / (2 * a);
			solutions[1] = (-b - Math.sqrt(diakrinousa)) / (2 * a);
			return solutions;
		} 
		
		if (diakrinousa <= Epsilon && diakrinousa >= 0) {
			double[] solutions = new double[1];
			solutions[0] = - b / (2 * a);
			return solutions;
		} 
        
		return null;
		
	}

	public double getDiscriminant() {
		return Math.pow(b, 2) - 4 * a * c;
	}
	
}
