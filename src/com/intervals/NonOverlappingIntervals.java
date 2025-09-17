package com.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };

		 Arrays.sort(intervals, (a,b)->{
             
             if(a[0]==b[0])
                 return Integer.compare(a[1],b[1]);

             return Integer.compare(a[0],b[0]);    
         });

		// Printing the sorted intervals
		for (int[] interval : intervals) {
			System.out.println(Arrays.toString(interval));
		}
	}
}
