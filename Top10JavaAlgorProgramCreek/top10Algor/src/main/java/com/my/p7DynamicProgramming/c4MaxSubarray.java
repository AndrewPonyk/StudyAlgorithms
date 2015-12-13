package com.my.p7DynamicProgramming;

import java.util.Arrays;
import static org.junit.Assert.*;

public class c4MaxSubarray {
    public static void main(String[] args) {
        System.out.println("FInd maximum subarray");
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // correct result {6, 3, 6}
        int[] arr1 = {4, 1, 5, 2, 0, 1, 9, 5}; // correct result {27, 0, 7}
        int[] arr2 = {2, -1, 7, -11, 6, -3, 10, 7, -1, -15, -1, 15, 3, -2}; // correct result {21, 4, 12}
        int[] arr3 = {-3, -2, -10, -11}; // correct is {-2, 1, 1}
        int[] arr4 = {-3, -2, 10, 11}; // correct is {21, 2, 3}

        System.out.println(Arrays.toString(maxSubArray(arr)));
        System.out.println(Arrays.toString(maxSubArray(arr1)));
        System.out.println(Arrays.toString(maxSubArray(arr2)));
        System.out.println(Arrays.toString(maxSubArray(arr3)));
        System.out.println(Arrays.toString(maxSubArray(arr4)));

        assertArrayEquals(new int[]{6, 3, 6}, maxSubArray(arr));
        assertArrayEquals(new int[]{27, 0, 7}, maxSubArray(arr1));
        assertArrayEquals(new int[]{21, 4, 12}, maxSubArray(arr2));
        assertArrayEquals(new int[]{-2, 1, 1}, maxSubArray(arr3));
    }

    /*
      returns array with 3 elements, first element is maxSum, second is startindex, third is lastindex
     */
    private static int[] maxSubArray(int[] arr) {
        int newSum = arr[0];
        int [] result = new int[3];
        result[0] = arr[0]; result[1] = 0; result[2] = 0;

        for (int i = 1; i < arr.length; i++) {
            if(newSum<0  && arr[i] >= newSum){
                result[1] = i;
            }
            newSum = Math.max(newSum + arr[i], arr[i]);

            if (newSum > result[0]) {
                result[2] = i;
            }
            result[0] = Math.max(newSum, result[0]);
        }

        return result;
    }
}