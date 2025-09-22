import java.util.HashMap;

class Solution {
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
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 2, 3, 1, 4, 2};
        System.out.println("Input: [1, 2, 2, 3, 1, 4, 2] → Result: " + sol.maxFrequencyElements(nums1));

        int[] nums2 = {5, 6, 7, 8};
        System.out.println("Input: [5, 6, 7, 8] → Result: " + sol.maxFrequencyElements(nums2));

        int[] nums3 = {9, 9, 9, 9};
        System.out.println("Input: [9, 9, 9, 9] → Result: " + sol.maxFrequencyElements(nums3));

        int[] nums4 = {1, 2, 2, 3, 3};
        System.out.println("Input: [1, 2, 2, 3, 3] → Result: " + sol.maxFrequencyElements(nums4));

        int[] nums5 = {};
        System.out.println("Input: [] → Result: " + sol.maxFrequencyElements(nums5));
    }
}