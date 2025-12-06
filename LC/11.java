import java_helper.GeneralHelper;

class Solution11 {
  public int maxArea(int[] height) {
    if (height.length < 2) return 0;

    int result = 0;
    int leftPointer = 0;
    int rightPointer = height.length - 1;

    while (leftPointer != rightPointer) {
      int currArea;

      if (height[leftPointer] < height[rightPointer]) {
        currArea = height[leftPointer] * (rightPointer - leftPointer);
        leftPointer++;
      } else {
        currArea = height[rightPointer] * (rightPointer - leftPointer);
        rightPointer--;
      }

      result = Math.max(currArea, result);
    }

    return result;
  }

  public static void main(String[] args) {
    Solution11 sol = new Solution11();
		
    int[][] testCases = {
      {1, 1},                           // minimal size
      {1, 2, 1},                        // symmetric peaks
      {4, 3, 2, 1, 4},                  // tall walls at both ends
      {1, 8, 6, 2, 5, 4, 8, 3, 7},      // classic LC example
      {2, 3, 4, 5, 18, 17, 6},          // large peak near middle
      {1, 3, 2, 5, 25, 24, 5},          // another classic container setup
      {10, 9, 8, 7, 6},                 // strictly decreasing
      {6, 7, 8, 9, 10},                 // strictly increasing
      {5, 5, 5, 5, 5},                  // all equal
      {1, 100, 1, 100, 1},              // alternating tall walls
      {2, 1, 2},                        // same height at edges
      {1000, 1, 1000},                  // extreme capacity at ends
      {3, 1, 2, 3},                     // mirror structure
      {9, 8, 7, 2, 1, 3},               // max at far left and near right
      {1, 2, 3, 4, 3, 2, 1},            // mountain shape
    };

    for (int[] testCase : testCases) {
      int result = sol.maxArea(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}