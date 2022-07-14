package com.strings;

import java.util.ArrayList;

import com.util.Util;

public class LPSArray {
	
	public static void main(String[] args) {
		Util.printArray(new LPSArray().calculateLPSArray("abcabc"));
		
		Util.printArrayList(new LPSArray().getZarr("abcabc"));
	}
	
	public int[] calculateLPSArray(String s) {

		int[] lps = new int[s.length()];

		int x = 0;

		for (int i = 1; i < s.length(); i++) {

			x = lps[i - 1];

			while (s.charAt(x) != s.charAt(i)) {

				if (x == 0) {
					x = -1;
					break;
				}
				x = lps[x - 1];
			}

			lps[i] = x + 1;

		}

		return lps;
	}
	
	
	 public ArrayList < Integer > getZarr(String str) {
	        int n = str.length();
	        // Z array
	        ArrayList < Integer > Z = new ArrayList < Integer > ();
	        for (int i = 0; i < n; i++) Z.add(0);
	        int L, R, k;
	        // [L,R] make a window which matches with prefix of s
	        L = R = 0;
	        for (int i = 1; i < n; ++i) {
	            // if i>R nothing matches so we will calculate.
	            // Z[i] using naive way.
	            if (i > R) {
	                L = R = i;
	                // R-L = 0 in starting, so it will start
	                // checking from 0'th index. For example,
	                // for "ababab" and i = 1, the value of R
	                // remains 0 and Z[i] becomes 0. For string
	                // "aaaaaa" and i = 1, Z[i] and R become 5
	                while (R < n && str.charAt(R - L) == str.charAt(R))
	                    R++;
	                Z.set(i, R - L);
	                R--;
	            } else {
	                // k = i-L so k corresponds to number which
	                // matches in [L,R] interval.
	                k = i - L;
	                // if Z[k] is less than remaining interval
	                // then Z[i] will be equal to Z[k].
	                // For example, str = "ababab", i = 3, R = 5
	                // and L = 2
	                if (Z.get(k) < R - i + 1)
	                    Z.set(i, Z.get(k));
	                // For example str = "aaaaaa" and i = 2, R is 5,
	                // L is 0
	                else {
	                    // else start from R and check manually
	                    L = i;
	                    while (R < n && str.charAt(R - L) == str.charAt(R))
	                        R++;
	                    Z.set(i, R - L);
	                    R--;
	                }
	            }
	        }
	        return Z;
	    }
}
