import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java_helper.GeneralHelper;

class Solution347 {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> numberOccurenceMappings = new HashMap<>();
    int[] result = new int[k];

    for (int index = 0; index < nums.length; index++) {
      numberOccurenceMappings.put(nums[index], numberOccurenceMappings.getOrDefault(nums[index], 0) + 1);
    }

    @SuppressWarnings("unchecked")
    List<Integer>[] buckets = new ArrayList[nums.length + 1];
    for (int index = 0; index < buckets.length; index++) buckets[index] = new ArrayList<>();
    
    for (int key : numberOccurenceMappings.keySet()) {
      buckets[numberOccurenceMappings.get(key)].add(key);
    }

    int count = 0;
    for (int i = buckets.length - 1; i >= 0 && count < k; i--) {
      for (int num : buckets[i]) {
        result[count++] = num;
        if (count == k) break;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution347 sol = new Solution347();

    Object[][] testCases = {
      { new int[]{1}, 1 },                                    // single element
      { new int[]{1, 1, 1, 2, 2, 3}, 2 },                     // classic LC example
      { new int[]{4, 4, 4, 4, 4}, 1 },                        // all same
      { new int[]{1, 2, 3, 4}, 2 },                           // all unique
      { new int[]{5, 5, 6, 6, 6}, 1 },                        // one element more frequent
      { new int[]{7, 7, 8, 8, 9, 9}, 3 },                     // all values tied
      { new int[]{10, 10, 10, 11, 11, 12}, 2 },               // two most frequent
      { new int[]{-1, -1, -1, -2, -2, -3}, 2 },               // negatives
      { new int[]{1000000000, 1000000000, -1000000000}, 1 },  // extreme boundary values
      { new int[]{3, 3, 4, 4, 4, 5, 5}, 2 }                   // one clear dominant + tie
    };


    for (Object[] testCase : testCases) {
      int[] result = sol.topKFrequent((int[]) testCase[0], (int) testCase[1]);
      GeneralHelper.printResult((int[]) testCase[0], (int) testCase[1], result);
    }
  }
}