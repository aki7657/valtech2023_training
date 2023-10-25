package com.valtech.training.day2;

import com.valtech.training.day1.Point;

public class PointArithmeticImpl implements PointArithmetic {

	@Override
	public Point additionOfTwoPoints(Point a, Point b) {
		int x = a.x + b.x;

		int y = a.y + b.y;

		Point p = new Point(x, y);

		return p;
	}

	@Override
	public Point subtractionOfTwoPoints(Point a, Point b) {
		int x = b.x - a.x;

		int y = b.y - a.y;

		Point p = new Point(x, y);

		return p;

	}

	@Override
	public double distanceOfTwoPoints(Point a, Point b) {
		int diffx = b.x - a.x;
		int diffy = b.y - a.y;
		return Math.sqrt(diffx*diffx + diffy*diffy);
	}

	public static void main(String[] args) {

		PointArithmetic p = new PointArithmeticImpl();

		Point a = new Point(10, 10);

		Point b = new Point(20, 20);

		Point p1 = p.additionOfTwoPoints(a, b);

		System.out.println("X = " + p1.x + " Y = " + p1.y);

		Point p2 = p.subtractionOfTwoPoints(a, b);

		System.out.println("X = " + p2.x + " Y = " + p2.y);

		System.out.println("The distance between the two points a and b is = " + p.distanceOfTwoPoints(a, b));

	}

}