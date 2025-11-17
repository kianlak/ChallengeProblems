import java_helper.GeneralHelper;

class Solution167 {
  public int[] twoSum(int[] numbers, int target) {
    int leftPointer = 0;
    int rightPointer = numbers.length - 1;

    while (leftPointer < rightPointer) {
      int sum = numbers[rightPointer] + numbers[leftPointer]; 
      
      if (sum == target) return new int[] {leftPointer + 1, rightPointer + 1};
      
      if (sum > target) rightPointer--;
      else if (sum < target) leftPointer++;
    }

    return new int[] {};
  }


  public static void main(String[] args) {
    Solution167 sol = new Solution167();

    Object[][] testCases = {
      { new int[]{2, 7, 11, 15}, 9 },             // classic example            → expected: [1, 2]
      { new int[]{2, 3, 4}, 6 },                  // simple sorted small case   → expected: [1, 3]
      { new int[]{-3, -1, 0, 2, 4, 5}, 1 },       // includes negatives         → expected: [2, 4]
      { new int[]{1, 3, 4, 5, 7, 10, 11}, 9 },    // mid array result           → expected: [3, 5]
      { new int[]{1, 2}, 3 },                     // smallest array size        → expected: [1, 2]
      { new int[]{5, 25, 75}, 100 },              // large jump between numbers → expected: [2, 3]
      { new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8 }, // two 4’s used               → expected: [4, 5]
      { new int[]{-10, -5, -2, 0, 3, 8, 12}, 7 }, // mix of negatives/positives → expected: [3, 7]
      { new int[]{1, 1, 3, 5}, 2 },               // duplicates at start        → expected: [1, 2]
      { new int[]{1, 2, 3, 4, 5, 6}, 11 },        // near end                   → expected: [5, 6]
    };

    for (Object[] testCase : testCases) {
      int[] result = sol.twoSum((int[]) testCase[0], (int) testCase[1]);

      GeneralHelper.printResult((int[]) testCase[0], (int) testCase[1], result);
    }
  }
}
