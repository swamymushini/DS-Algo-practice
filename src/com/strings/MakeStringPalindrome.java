package com.strings;

public class MakeStringPalindrome {

	public static void main(String[] args) {
		System.out.println(new MakeStringPalindrome().solve("ababa"));
	}

	  public int solve(String A) {

	        StringBuilder sb = new StringBuilder();
	        sb.append(A);
	        
	        String res = A+"$"+sb.reverse().toString();

	        int[] lps = new LPSArray().calculateLPSArray(res);

	        return A.length()-lps[res.length()-1];
	    }

}
