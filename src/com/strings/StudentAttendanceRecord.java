package com.strings;

public class StudentAttendanceRecord {
    
    public static void main(String[] args) {
        
        int n =4;

        int[] arr = new int[]{1,1,1,0};

        int i = 1;

        while(i<n){

            int pr = arr[0];
            int abs = arr[1];
            int lat1 = arr[2];
            int lat2 = arr[3];

            int nPr = 0;
            int nAbs = 0;
            int nLat1 = 0;
            int nLat2 = 0;

            nPr = pr+lat1+lat2;

            nAbs = abs+abs+pr+lat1+lat2;

            nLat1 = pr;

            nLat2 = lat1;
            
            i++;

            arr[0] = nPr;
            arr[1] = nAbs;
            arr[2] = nLat1;
            arr[3] = nLat2;
            
            System.out.println(arr[0]+", "+arr[1]+", "+arr[2]+", "+arr[3]);
        }


        System.out.println(arr[0]+arr[1]+arr[2]+arr[3]);

    }

}
