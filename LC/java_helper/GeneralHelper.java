package java_helper;

import java.util.Arrays;
import java.util.List;

public class GeneralHelper {
	private static int caseNum = 1;

	/* Input int 
	 * Result int
	 */
	public static void printResult(int num, int result) {
		System.out.println("Test Case #" + caseNum++);
		System.out.println("Input : " + num);
		System.out.println("Result: " + result + "\n");
	}

	/* Input int[] 
	 * Result int
	 */
	public static void printResult(int[] nums, int result) {
		System.out.println("Test Case #" + caseNum++);
		System.out.println("Input : " + Arrays.toString(nums));
		System.out.println("Result: " + result + "\n");
	}

	/* Input int[], int[]
	 * Result int
	 */
	public static void printResult(int[] nums1, int[]nums2, int result) {
		System.out.println("Test Case #" + caseNum++);
		System.out.println("Input 1 : " + Arrays.toString(nums1));
		System.out.println("Input 2 : " + Arrays.toString(nums2));
		System.out.println("Result: " + result + "\n");
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

    System.out.println("\n");
	}

	/* Input String
	 * Result boolean
	 */
	public static void printResult(String str, boolean result) {
		System.out.println("Test Case #" + caseNum++);
		System.out.println("Input : " + str);
		System.out.println("Result: " + result + "\n");
	}

	/* Input String[] 
	 * Result int
	 */
	public static void printResult(String[] strs, int result) {
		System.out.println("Test Case #" + caseNum++);
		System.out.println("Input : " + Arrays.toString(strs));
		System.out.println("Result: " + result + "\n");
	}


	/* SPECIAL CASE PRINTING FORMATTING */

	/* Input int 
	 * Result List<List<Integer>>
	 */
	public static void printResultSpecialCasePyramid(int num, List<List<Integer>> result) {
		System.out.println("Test Case #" + caseNum++);
    System.out.println("Input : " + num);
    System.out.println("Result (Pascal’s Triangle):");

    if (result == null || result.isEmpty()) {
			System.out.println("  [empty]\n");
			return;
    }

    int maxAbs = 0;
    for (List<Integer> row : result) {
			for (int v : row) maxAbs = Math.max(maxAbs, Math.abs(v));
    }
    int digitWidth = Math.max(1, String.valueOf(maxAbs).length());
    int spaceBetween = 1;

    int lastCols = result.get(result.size() - 1).size();
    int totalWidthLast = lastCols * digitWidth + (lastCols - 1) * spaceBetween;

    for (List<Integer> row : result) {
			int cols = row.size();
			int rowWidth = cols * digitWidth + (cols - 1) * spaceBetween;
			int padding = Math.max(0, (totalWidthLast - rowWidth) / 2);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < padding; i++) sb.append(' ');

			for (int i = 0; i < cols; i++) {
				if (i > 0) sb.append(' ');
				sb.append(String.format("%" + digitWidth + "d", row.get(i)));
			}

			System.out.println(sb.toString());
    }
	}
}