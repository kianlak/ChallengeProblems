import java_helper.GeneralHelper;

import java.util.HashMap;

class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int currMaxFrequency = 0;
        int totalMaxFrequency = 0;

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

            if (currMaxFrequency < frequency.get(num)) {
                currMaxFrequency = frequency.get(num);
            }
        }

        for(Integer value : frequency.values()) {
            if (value == currMaxFrequency) totalMaxFrequency += value;
        }

        return totalMaxFrequency;
    }

    public static void main(String[] args) {
        Solution3005 sol = new Solution3005();

        int[][] testCases = {
            {1, 2, 2, 3, 1, 4, 2},          // normal
            {5, 6, 7, 8},                   // all unique
            {9, 9, 9, 9},                   // all same
            {1, 2, 2, 3, 3},                // tie for max frequency
            {1},                            // single element
            {2, 2, 2, 3, 3, 4, 4},          // one dominant, others smaller
            {10, 11, 10, 11},               // equal tie
            {7, 7, 8, 8, 9, 9},             // multiple ties
            {42, 42, 42, 42, 42, 42, 42},   // all same (longer length within bounds)
            {1, 1, 2, 2, 3, 3, 4, 4},       // even tie across many
            {1, 2, 3, 4, 5, 6, 7, 8, 9},    // large unique sequence
            {1, 1, 2, 2, 2, 3, 3, 3},       // tie with different values but same total
            {1, 2, 3, 4, 1, 2, 3, 4, 1},    // repeating pattern
            {1, 1, 1, 2, 2, 2, 3, 3, 3},    // multiple equal groups
            {50, 60, 70, 50, 60, 50},       // sparse larger values within [1,100]
            {100, 100, 100, 99, 99, 98},    // upper bound values
        };

        for (int[] testCase : testCases) {
            int result = sol.maxFrequencyElements(testCase);
            GeneralHelper.printResult(testCase, result);
        }
    }
}