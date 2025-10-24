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
      0,   // edge case: no steps (1 way)                  → expected: 1
      1,   // single step                                 → expected: 1
      2,   // two ways: (1+1), (2)                        → expected: 2
      3,   // three ways: (1+1+1), (1+2), (2+1)           → expected: 3
      4,   // five ways (Fibonacci pattern continues)     → expected: 5
      5,   // eight ways                                  → expected: 8
      10,  // medium input, check iteration correctness   → expected: 89
      20,  // larger input, performance validation        → expected: 10946
      45   // upper bound constraint                      → expected: 1836311903
    };

    for (int testCase : testCases) {
      int result = sol.climbStairs(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}