package java_helper;

import java.util.Arrays;

public class GeneralHelper {
	private static int caseNum = 1;

	/* Input int[] 
	 * Result int
	 */
	public static void printResult(int[] nums, int result) {
		System.out.println("Test Case #" + caseNum++);
		System.out.println("Input : " + Arrays.toString(nums));
		System.out.println("Result: " + result);
		System.out.println();
	}

	/* Input int[], int[]
	 * Result int
	 */
	public static void printResult(int[] nums1, int[]nums2, int result) {
		System.out.println("Test Case #" + caseNum++);
		System.out.println("Input 1 : " + Arrays.toString(nums1));
		System.out.println("Input 2 : " + Arrays.toString(nums2));
		System.out.println("Result: " + result);
		System.out.println();
	}

	/* Input int[][] 
	 * Result int[][] 
	 */
	public static void printResult(int[][] nums, int[][] result) {
		System.out.println("Test Case #" + caseNum++);
    
    System.out.println("Input :");
    for (int[] row : nums) {
			System.out.println(Arrays.toString(row));
    }

    System.out.println("\nResult:");
    for (int[] row : result) {
			System.out.println(Arrays.toString(row));
    }

    System.out.println();
	}

	/* Input String[] 
	 * Result int
	 */
	public static void printResult(String[] strs, int result) {
		System.out.println("Test Case #" + caseNum++);
		System.out.println("Input : " + Arrays.toString(strs));
		System.out.println("Result: " + result);
		System.out.println();
	}
}