import java_helper.GeneralHelper;

class Solution70 {
  public int climbStairs(int n) {
    if (n == 0 || n == 1) return 1;

    int[] stepFrequency = new int[n + 1];
    stepFrequency[0] = 1;
    stepFrequency[1] = 1;

    for (int step = 2; step <= n; step++) {
      stepFrequency[step] = stepFrequency[step - 1] + stepFrequency[step - 2];
    }

    return stepFrequency[n];
  }

  public static void main(String[] args) {
    Solution70 sol = new Solution70();

    int[] testCases = {
      0,   // edge case: no steps (1 way)
      1,   // single step
      2,   // two ways: (1+1), (2)
      3,   // three ways: (1+1+1), (1+2), (2+1)
      4,   // five ways (Fibonacci pattern continues)
      5,   // eight ways
      10,  // medium input, check iteration correctness
      20,  // larger input, performance validation 
      45   // upper bound constraint
    };

    for (int testCase : testCases) {
      int result = sol.climbStairs(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}