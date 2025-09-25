import java_helper.GeneralHelper;

import java.util.HashMap;

class Solution3005 {
  public int maxFrequencyElements(int[] nums) {
    HashMap<Integer, Integer> frequency = new HashMap<>();
    int currMaxFrequency = 0;
    int totalMaxFrequency = 0;

    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);

      if (currMaxFrequency < frequency.get(num)) currMaxFrequency = frequency.get(num);
    }

    for(Integer value : frequency.values()) {
      if (value == currMaxFrequency) totalMaxFrequency += value;
    }

    return totalMaxFrequency;
  }

  public static void main(String[] args) {
    Solution3005 sol = new Solution3005();

    int[][] testCases = {
      {1, 2, 2, 3, 1, 4, 2},        // normal                                   → result=3
      {5, 6, 7, 8},                 // all unique                               → result=4
      {9, 9, 9, 9},                 // all same                                 → result=4
      {1, 2, 2, 3, 3},              // tie for max frequency                    → result=4
      {1},                          // single element                           → result=1
      {2, 2, 2, 3, 3, 4, 4},        // one dominant, others smaller	            → result=3
      {10, 11, 10, 11},             // equal tie                                → result=4
      {7, 7, 8, 8, 9, 9},           // multiple ties                            → result=6
      {1, 1, 2, 2, 3, 3, 4, 4},     // even tie across many                     → result=8
      {1, 2, 3, 4, 5, 6, 7, 8, 9},  // large unique sequence                    → result=9
      {1, 1, 2, 2, 2, 3, 3, 3},     // tie with different values but same total → result=6
      {1, 2, 3, 4, 1, 2, 3, 4, 1},  // repeating pattern                        → result=3
      {1, 1, 1, 2, 2, 2, 3, 3, 3},  // multiple equal groups                    → result=9
      {50, 60, 70, 50, 60, 50},     // sparse larger values within [1,100]      → result=3
      {100, 100, 100, 99, 99, 98},  // upper bound values                       → result=3
    };
    
    for (int[] testCase : testCases) {
      int result = sol.maxFrequencyElements(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}