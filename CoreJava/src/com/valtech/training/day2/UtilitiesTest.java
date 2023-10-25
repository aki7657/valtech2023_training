package com.valtech.training.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

//	Methods and Variables naming convention : First letter should be lower case and then rest significant words should start with a capital letter with no spaces/underscores
//	Class naming convention : First letter should be capital and all significant words should start with a capital letter with no spaces/underscores

import com.valtech.training.day1.Point;

public class UtilitiesTest {
	
	public static void testStack(Stack<Point> points) {
		
		points.push(new Point(2,3));
		points.push(new Point(2,4));
		points.push(new Point(2,3));
		points.push(new Point(2,5));
		System.out.println("Size = " + points.size());
		System.out.println(points.pop());
		System.out.println("Size = " + points.size());
		System.out.println(points.peek());
		System.out.println("Size = " + points.size());
//		Stack allows duplicates because stack extends vectors and vectors implement Links which allow duplicates
//		Pop views and removes the top most element in the stack whereas peek only views the top most element without removing it and hence we can view the same element multiple times with peek
		
	}
	
	public static void testMap(Map<String,Point> points) {
		
		points.put("2,3", new Point(2,3));
		points.put("2,3", new Point(2,3));
		points.put("3,2", new Point(3,2));
		points.put("2,4", new Point(2,4));
		points.put("4,2", new Point(2,4));
//		Since key is different it'll think that it is a new value as it does not have the capability to check the content
//		Tree map will give order based on the natural order of the keys and not the content
//		Keys are of class string and values are a part of the class 'point'
//		Key values are given by the person who is writing the code or as an input from the user.
		System.out.println(points.size());
		System.out.println(points);
		
	}
	
	public static void testList(List<Point>points) {
		
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);
//		Set<Point> points = new HashSet<>();
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		points.add(new Point(2,4));
		points.add(new Point(4,2));
//		points.add(new Point(3,4));
		System.out.println("Size = " + points.size());
		System.out.println(points);
		
	}
	
//	public static void testHashSet() {
	public static void testSet(Set<Point> points) {
		
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);
//		Set<Point> points = new HashSet<>();
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		points.add(new Point(2,4));
		points.add(new Point(4,2));
//		points.add(new Point(3,4));
		System.out.println("Size = " + points.size());
		System.out.println(points);
		
	}

	public static void main(String[] args) {
//		testSet(new HashSet<>());
//		testSet(new TreeSet<>());
//		testList(new ArrayList<>());
//		testList(new LinkedList<>());
//		testMap(new HashMap<>());
//		testMap(new TreeMap<>());
		testStack(new Stack<>());

	}

}
