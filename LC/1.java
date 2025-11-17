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
      { new int[]{2, 7, 11, 15}, 9 },                     // classic example                    → expected: [0, 1]
      { new int[]{3, 2, 4}, 6 },                          // complement in middle               → expected: [1, 2]
      { new int[]{3, 3}, 6 },                             // pair of duplicates                 → expected: [0, 1]
      { new int[]{-1, -2, -3, -4, -5}, -8 },              // negative numbers                   → expected: [2, 4]
      { new int[]{4, -2, 5, 11}, 9 },                     // mix of pos/neg                     → expected: [1, 3]
      { new int[]{1, -1, 2, -2, 3}, 0 },                  // target zero                        → expected: [0, 1]
      { new int[]{10, 20, 10, 40, 50}, 20 },              // duplicate value provides solution  → expected: [0, 2]
      { new int[]{1000000000, -1000000000, 3, 7}, 10 },   // extreme bounds values              → expected: [2, 3]
      { new int[]{5, 9, 1, 3, 4, 9}, 18 },                // duplicate forms solution at end    → expected: [1, 5]
      { new int[]{8, 2, 5, 7}, 10 },                      // solution at beginning              → expected: [0, 1]
      { new int[]{12, 7, 19, 3, 5, 8}, 11 },              // scattered numbers                  → expected: [1, 4]
      { new int[]{100, 200, 300, 400, 500, 600}, 1100 },  // large target                       → expected: [4, 5]
    };

    for (Object[] testCase : testCases) {
      int[] result = sol.twoSum((int[]) testCase[0], (int) testCase[1]);

      GeneralHelper.printResult((int[]) testCase[0], (int) testCase[1], result);
    }
  }
}