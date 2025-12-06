import java.util.HashMap;

import java_helper.GeneralHelper;

class Solution1 {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> complementMap = new HashMap<>();

    for (int index = 0; index < nums.length; index++) {
      int complement  = target - nums[index];

      if (complementMap.containsKey(nums[index])) return new int[] { complementMap.get(nums[index]), index };
      
      complementMap.put(complement, index);
    }

    return new int[] {};
  }

  public static void main(String[] args) {
    Solution1 sol = new Solution1();

    Object[][] testCases = {
      { new int[]{2, 7, 11, 15}, 9 },                     // classic example
      { new int[]{3, 2, 4}, 6 },                          // complement in middle
      { new int[]{3, 3}, 6 },                             // pair of duplicates
      { new int[]{-1, -2, -3, -4, -5}, -8 },              // negative numbers
      { new int[]{4, -2, 5, 11}, 9 },                     // mix of pos/neg
      { new int[]{1, -1, 2, -2, 3}, 0 },                  // target zero
      { new int[]{10, 20, 10, 40, 50}, 20 },              // duplicate value provides solution
      { new int[]{1000000000, -1000000000, 3, 7}, 10 },   // extreme bounds values
      { new int[]{5, 9, 1, 3, 4, 9}, 18 },                // duplicate forms solution at end
      { new int[]{8, 2, 5, 7}, 10 },                      // solution at beginning
      { new int[]{12, 7, 19, 3, 5, 8}, 11 },              // scattered numbers
      { new int[]{100, 200, 300, 400, 500, 600}, 1100 },  // large target
    };

    for (Object[] testCase : testCases) {
      int[] result = sol.twoSum((int[]) testCase[0], (int) testCase[1]);

      GeneralHelper.printResult((int[]) testCase[0], (int) testCase[1], result);
    }
  }
}