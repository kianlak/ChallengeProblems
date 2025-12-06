import java_helper.GeneralHelper;

import java.util.Set;
import java.util.HashSet;

class Solution217 {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> numSet = new HashSet<>();

    for (int num : nums) {
      if (numSet.contains(num)) return true;
      
      numSet.add(num);
    }

    return false;
  }

  public static void main(String[] args) {
    Solution217 sol = new Solution217();

    int[][] testCases = {
      {1},                                              // single element
      {5, 5},                                           // simple duplicate
      {-1, -2, -3, -4},                                 // all unique negative
      {1000000000, -1000000000},                        // extreme values, unique
      {7, 8, 9, 7},                                     // duplicate at edges
      {0, 0, 0, 0},                                     // all same
      {3, 1, 4, 2, 5, 6, 3},                            // duplicate in middle
      {-10, 20, -30, 40, -10},                          // negative + positive, dup
      {9, 8, 7, 6, 5, 4, 3, 2, 1},                      // reversed unique sequence
      {1, 2, 3, 4, 5, 1},                               // duplicate at end
      {500000000, -500000000, 123456789, -987654321},   // wide range, unique
      {2, 4, 6, 8, 10, 12, 14},                         // all unique evens
      {-1000000000, -999999999, -1000000000},           // extreme negative duplicate
      {42, 13, 7, 42, 13},                              // multiple repeated
    };
    
    for (int[] testCase : testCases) {
      boolean result = sol.containsDuplicate(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}