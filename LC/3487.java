import java_helper.GeneralHelper;

import java.util.HashSet;
import java.util.Set;

class Solution3487 {
    public int maxSum(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        int currMaxValue = Integer.MIN_VALUE;
        boolean isPositive = false;
        int sum = 0;

        for (int num : nums) {
            if (num >= 0) {
                isPositive = true;
                
                if (!uniqueNums.contains(num)) sum += num;

                uniqueNums.add(num);
            } else if (!isPositive) currMaxValue = Math.max(num, currMaxValue);
        }

        return isPositive ? sum : currMaxValue;
    }

    public static void main(String[] args) {
        Solution3487 sol = new Solution3487();
        
        int[][] testCases = {
            {1, 2, 2, 3, 4},            // mix with duplicates
            {-5, -2, -3, -4},           // all negative
            {0, 1, 2, 3},               // includes zero
            {10, 20, 30, 10},           // duplicate max values
            {-1},                       // single negative
            {5},                        // single positive
            {-7, -3, -9, -1, -2},       // largest negative chosen
            {50, 60, 50, 70},           // within valid bounds
            {100, 100, 99, 98},         // upper bound values
            {-100, -50, -100},          // lower bound values
        };

        for (int[] testCase : testCases) {
            int result = sol.maxSum(testCase);
            GeneralHelper.printResult(testCase, result);
        }
    }
}