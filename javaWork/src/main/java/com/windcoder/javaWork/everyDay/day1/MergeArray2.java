package com.windcoder.javaWork.everyDay.day1;

public class MergeArray2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length,i=m-1,j=n-1;
        for(int k=len-1;k>=0;k--) {
            if (j<0||(i>=0 && nums1[i]>=nums2[j])) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k]=nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a ={1};
        MergeArray2 array2 = new MergeArray2();
        array2.merge(a,1, new int[]{0},0);
    }
}
