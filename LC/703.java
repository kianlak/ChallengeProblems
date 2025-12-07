import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import java_helper.GeneralHelper;

class Solution703 {
  class KthLargest {
    PriorityQueue<Integer> testScores = new PriorityQueue<>();
    public int k;

    public KthLargest(int k, int[] nums) {
      this.k = k;

      for (int num : nums) {
        if (testScores.size() == k) {
          if (num > testScores.peek()) {
            testScores.poll();
            testScores.add(num);
          }
        }
        else testScores.add(num);
      }
    }
      
    public int add(int val) {
      if (testScores.size() < k) testScores.add(val);

      else if (val > testScores.peek()) {
        testScores.poll();
        testScores.add(val);
      }

      return testScores.peek();
    }
  }

  public static void main(String[] args) {
    Solution703 sol = new Solution703();

    Object[][] testCases = {
      // basic initialization + sequential adds
      {
        new String[]{"KthLargest", "add", "add", "add", "add", "add"},
        new Object[]{ new Object[]{2, new int[]{0}}, -1, 1, -2, -4, 3 }
      },
      // k = 1 → always return largest
      {
        new String[]{"KthLargest", "add", "add", "add"},
        new Object[]{ new Object[]{1, new int[]{5, 3, 4}}, 2, 10, 1 }
      },
      // all negative values
      {
        new String[]{"KthLargest", "add", "add", "add", "add"},
        new Object[]{ new Object[]{3, new int[]{-10, -20, -30}}, -5, -15, -25, -35 }
      },
      // nums initially empty
      {
        new String[]{"KthLargest", "add", "add", "add"},
        new Object[]{ new Object[]{3, new int[]{}}, 4, 5, 6 }
      },
      // many duplicates
      {
        new String[]{"KthLargest", "add", "add", "add", "add"},
        new Object[]{ new Object[]{2, new int[]{5, 5, 5}}, 5, 3, 8, 5 }
      },
      {
        // randomized increasing + decreasing
        new String[]{"KthLargest", "add", "add", "add", "add", "add"},
        new Object[]{ new Object[]{3, new int[]{4, 10, 2}}, 6, 20, 15, 1, 9 }
      }
    };

    for (Object[] testCase : testCases) {
      String[] operations = (String[]) testCase[0];
      Object[] values     = (Object[]) testCase[1];

      List<String> output = new ArrayList<>();
      Solution703.KthLargest kth = null;

      for (int i = 0; i < operations.length; i++) {
        String op = operations[i];

        switch (op) {
          case "KthLargest":
            Object[] init = (Object[]) values[i];
            int k = (int) init[0];
            int[] nums = (int[]) init[1];

            kth = sol.new KthLargest(k, nums);
            output.add("KthLargest(" + k + ", " + java.util.Arrays.toString(nums) + ") → null");
            break;

          case "add":
            int val = (int) values[i];
            int result = kth.add(val);

            output.add("add(" + val + ") → " + result);
            break;
        }
      }
      
      GeneralHelper.printResultSpecialCaseLogsOperationOnClasses(output);
    }
  }
}