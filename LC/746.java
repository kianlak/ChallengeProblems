import java_helper.GeneralHelper;

class Solution746 {
  public int minCostClimbingStairs(int[] cost) { 
    int[] totalAtIndex = new int[cost.length];

    totalAtIndex[0] = cost[0];
    totalAtIndex[1] = cost[1];

    for (int index = 2; index < cost.length; index++) {
      totalAtIndex[index] = Math.min(totalAtIndex[index - 1], totalAtIndex[index - 2]) + cost[index];
    }

    return Math.min(totalAtIndex[cost.length - 1], totalAtIndex[cost.length - 2]);
  }

  public static void main(String[] args) {
    Solution746 sol = new Solution746();
		
    int[][] testCases = {
      {10, 15, 20},                         // simple 3-step
      {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, // classic LC example
      {0, 0, 0, 0},                         // all zero
      {1, 1, 1, 1},                         // uniform costs
      {5, 10, 5, 10, 5},                    // alternating pattern
      {3, 2, 4, 1},                         // best path avoids big values
      {2, 3},                               // exactly 2 steps
      {7, 5, 3, 1},                         // decreasing costs
      {100, 1, 1, 1, 100},                  // avoid expensive edges
      {5, 6, 7, 8, 9},                      // pure increasing
      {9, 8, 7, 6, 5},                      // pure decreasing
      {1},                                  // single element
      {2, 5, 2},                            // middle large, avoid it
      {10, 5, 10},                          // take cheaper middle
      {4, 1, 5, 1, 4},                      // weave between low-cost spots
    };

    for (int[] testCase : testCases) {
      int result = sol.minCostClimbingStairs(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}