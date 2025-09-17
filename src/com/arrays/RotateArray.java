package com.arrays;
public class RotateArray {
    public void rotate(int[] a, int k) {

        if (a.length == 1)
            return;

        k = k % a.length;
        rotateArray(a,0,a.length-1);
        rotateArray(a,0,k-1);
        rotateArray(a,k,a.length-1);
    }

    public void rotateArray(int[] a, int i, int j) {
        
        while(i<j){
            int swap = a[j];
            a[j] = a[i];
            a[i] = swap;
            j--;
            i++;
        }
    }
}