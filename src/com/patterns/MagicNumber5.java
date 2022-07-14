package com.patterns;
public class MagicNumber5 {
	
	public static void main(String[] args) {
	new MagicNumber5().solve(3);	
	}
	
    public int solve(int A) {
        int res = 0;
        int i =0;
        
        while(A>0){

            if((A&1)==1)
                res = res+ (int)Math.pow(5,i);
            
            System.out.println(res);
            
            i++;
            A = A>>1;
        }

        return res;
    }
}
