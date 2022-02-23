package com.windcoder.javaWork.everyDay.day1;

public class MergeArray1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        int[] aryy = new int[len];
        int i =0,j=0;int cnt=0;
        while(i<m||j<n) {
            if(j>=n||(i<m && nums1[i]<=nums2[j])) {
                aryy[cnt]=nums1[i];
                i++;
            } else {
                aryy[cnt]=nums2[j];
                j++;
            }
            cnt++;
        }

        for(int k=0;k<len;k++) {
            nums1[k]=aryy[k];
        }
    }

    public static void main(String[] args) {
        int[] a ={1};
        MergeArray1 array1 = new MergeArray1();
        array1.merge(a,1, new int[]{0},0);

        int[] b= new int[3];
        b[0]=1;
        for (int i=0;i<3;i++) {
            System.out.println(b[i]);
        }


    }
}
