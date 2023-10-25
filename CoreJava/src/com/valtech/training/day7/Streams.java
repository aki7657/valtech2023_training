package com.valtech.training.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	
	private void traditional() {
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		very helpful method for adding values into an array. Otherwise we need to create a for loop or create new object through an instance and populate the same
		List<Integer> sqrs = new ArrayList<>();
		for(int i : nums) {
			sqrs.add(i*i);
		}
		System.out.println(nums);
		System.out.println(sqrs);
	}
	
	public static void main(String[] args) {
		Streams s = new Streams();
		s.traditional();
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> sqrs1 = nums.stream().map(i->i*i).collect(Collectors.toList());
		List<Double> sqrts = nums.stream().map(i-> Math.sqrt(i)).collect(Collectors.toList());
		List<Integer> odd = nums.stream().filter(i->(i % 2) == 1).collect(Collectors.toList());
		List<Integer> oddsqrs = odd.stream().map(i->i*i).collect(Collectors.toList());
//		we use map when we are transforming the array, filter when we want to filter out specific values, here we want only wadd values so we are using them in the filter function
		System.out.println(sqrs1);
 		System.out.println(sqrts);
 		System.out.println(odd);
 		System.out.println(oddsqrs);
	}

}
