package com.my.p1StringArray;

import java.util.stream.IntStream;

import org.junit.Assert;

public class c12MergeSortedArrays {
	public static void main(String[] args) {
		System.out.println("Merging arrays ");
		testMerge();
		testMerge2();
		testMerge3();
		testMerge4();
	}

	public static int[] mergeArrays(int [] a, int [] b) {
		int [] result = new int[a.length + b.length];
		int ai = 0 , bi = 0;
		int minLength = a.length < b.length ? a.length : b.length;
		int nextIndex = 0;

		for (int i = 0; ai < minLength && bi < minLength; i++) {
			if( a[ai] < b[bi]){
				result[i] = a[ai++];
			}else{
				result[i] = b[bi++];
			}
			nextIndex = i + 1;
		}

		for(int i = ai; i < a.length; i++ ){
			result[nextIndex++] = a[i];
		}

		for(int i = bi; i < b.length; i++ ){
			result[nextIndex++] = b[i];
		}

		//IntStream.range(0, result.length).forEach(e->{System.out.print(result[e] + " ");});
		return result;
	}

	public static void testMerge(){
		int [] a = {1, 2, 10, 1000};
		int [] b = {4, 11, 55, 555, 2000};
		int [] merged = mergeArrays(a, b);

		Assert.assertArrayEquals(merged, new int[]{1, 2, 4, 10, 11, 55, 555, 1000, 2000});
		System.out.println("Test Passed : testMerge");
	}

	public static void testMerge2(){
		int [] a = {10};
		int [] b = {-11, 55, 555, 2000};
		int [] merged = mergeArrays(a, b);

		Assert.assertArrayEquals(merged, new int[]{-11, 10, 55, 555, 2000});
		System.out.println("Test Passed : testMerge2");
	}

	public static void testMerge3(){
		int [] a = {};
		int [] b = {11, 55, 555, 2000};
		int [] merged = mergeArrays(a, b);

		Assert.assertArrayEquals(merged, new int[]{11, 55, 555, 2000});
		System.out.println("Test Passed : testMerge3");
	}

	public static void testMerge4(){
		int [] a = {};
		int [] b = {};
		int [] merged = mergeArrays(a, b);

		Assert.assertArrayEquals(merged, new int[]{});
		System.out.println("Test Passed : testMerge4");
	}
}
