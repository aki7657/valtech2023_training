package com.valtech.training.day7;

//
//import java.util.Arrays;
//import java.util.List;
//
public class ArrayMountainChallenge {
//	
//	public static boolean isAscending(int[] arr, int peak) {
//		
//		for(int i =0; i< arr.peak -1 ; i++ ) {
//			if(arr[i]>arr[i+1]) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public static boolean isDescending(int[] arr, int peak) {
//		
//		for(int i=0; i<arr.length -1; i++) {
//			if(arr[i]<arr[i+1]) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public static int maxElement(int[] arr) {
//		int index =0;
//		int max = arr[0];
//		for(int i=0;i<arr.length -1; i++) {
//			if(arr[i]>max) {
//				max=arr[i];
//				index=i;
//			}
//		}
//		return index;
//	
//	}
//	
//	private boolean isMountain(int ... i) {
//		
//		int peak = maxElement(i);
//		 
//		boolean asc = isAscending(i, peak);
//		
//		boolean desc = isDescending(i, peak);
//		
//		return
//		
//	}
//
//	public static void main(String[] args) {
//		List<Integer> arr = Arrays.asList(2, 4, 5, 8, 7, 6, 3, 1);
//
//		
//		
//	}
//
//}

//package com.valtech.training;

//public class NumberMountain {

	public static void main(String[] args) {

		ArrayMountainChallenge nm = new ArrayMountainChallenge();

		System.out.println(nm.isMountain(4, 5, 3, 2, 1));

		System.out.println(nm.isMountain(4, 3, 3, 2, 1));

		System.out.println(nm.isMountain(6, 5, 3, 2, 1));

		System.out.println(nm.isMountain(4, 5, 3, 5, 1));

		System.out.println(nm.isMountain(4, 5, 3, 2, 1));

		System.out.println(nm.isMountain(4, 5, 6, 7, 8));

	}

	private boolean isMountain(int... i) {

		// identify peak

		int peak = identifyPeak(i);

		if (peak == 0 || peak == i.length - 1)
			return false;

		// check if it is in asc

		boolean asc = checkAscending(i, peak);

		// check if other portion is in desc

		boolean desc = checkDescending(i, peak);

		return asc && desc;

	}

	private boolean checkDescending(int[] i, int peak) {

		boolean desc = true;

		for (int j = 0; j < i.length - 1; j++) {

			if (i[j] < i[j + 1]) {

				desc = false;

			}

		}

		return desc;

	}

	private boolean checkAscending(int[] i, int peak) {

		boolean asc = true;

		for (int j = 0; j < peak - 1; j++) {

			if (i[j] > i[j + 1]) {

				asc = false;

			}

		}

		return asc;

	}

	private int identifyPeak(int[] i) {

		int index = 0;

		int max = 0;

		for (int j = 0; j < i.length; j++) {

			if (i[j] > max) {

				max = i[j];

				index = j;

			}

		}

		return index;

	}

}
