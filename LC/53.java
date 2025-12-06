import java_helper.GeneralHelper;

class Solution53 {
  public int maxSubArray(int[] nums) {
    int result = nums[0];
    int currSum = result;

    for (int index = 1; index < nums.length; index++) {
      currSum += nums[index];

      if (currSum < nums[index]) currSum = nums[index];

      result = Math.max(result, currSum); 
    }
    
    return result;
  }

  public static void main(String[] args) {
    Solution53 sol = new Solution53();
		
    int[][] testCases = {
      {-1, -2, -3, -4},                     // all negative values
      {1},                                  // single element
      {5, -1, 2, -1, 3},                    // mixed positives and negatives
      {-2, 1, -3, 4, -1, 2, 1, -5, 4},      // classic LC example
      {1, 2, 3, 4, 5},                      // strictly increasing
      {5, 4, 3, 2, 1},                      // strictly decreasing
      {2, -1, 2, -1, 2},                    // alternating up and down
      {-1, -2, -3, 10},                     // large positive at end
      {10, -5, -6, -7, 20},                 // two peaks separated by negatives
      {100, -90, 80, -70, 60},              // staggered positive bursts
      {3, -2, 5, -1},                       // small mid positive boost
      {1, -1, 1, -1, 1, -1, 1},             // oscillating around zero
      {8, -19, 5, -4, 20},                  // deep drop then strong recovery
      {-2, -1},                             // small negative list
      {-2, -3, 4, -1, -2, 1, 5, -3},        // mixed with long positive segment
    };


    for (int[] testCase : testCases) {
      int result = sol.maxSubArray(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}