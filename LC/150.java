import java.util.Stack;

import java_helper.GeneralHelper;

class Solution150 {
  public int evalRPN(String[] tokens) {
    Stack<Integer> totalStack = new Stack<>();

    for (String token : tokens) {
      if (token.equals("+") || 
          token.equals("-") ||
          token.equals("*") || 
          token.equals("/")) {
          
        int total;
        int num2 = totalStack.pop();
        int num1 = totalStack.pop();

        switch (token) {
          case "+":
            total = num1 + num2;
            break;
          case "-":
            total = num1 - num2;
            break;
          case "*":
            total = num1 * num2;
            break;
          case "/":
            total = num1 / num2;
            break;
          default:
            return -1;
        }

        totalStack.add(total);
      } else totalStack.add(Integer.parseInt(token));
    }

    return totalStack.pop();
  }

  public static void main(String[] args) {
    Solution150 sol = new Solution150();

    String[][] testCases = {
      {"2", "1", "+", "3", "*"},                                              // (2 + 1) * 3                        → expected: 9
      {"4", "13", "5", "/", "+"},                                             // 4 + (13 / 5)                       → expected: 6
      {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"},  // complex long expression            → expected: 22
      {"18"},                                                                 // single value                       → expected: 18
      {"3", "4", "-"},                                                        // 3 - 4                              → expected: -1
      {"5", "1", "2", "+", "4", "*", "+", "3", "-"},                          // classic: 5 + ((1 + 2) * 4) - 3     → expected: 14
      {"7", "2", "/"},                                                        // integer division                   → expected: 3
      {"-4", "2", "/"},                                                       // negative integer division          → expected: -2
      {"0", "3", "/"},                                                        // zero numerator                     → expected: 0
      {"5", "9", "*"},                                                        // 5 * 9                              → expected: 45
      {"15", "7", "1", "1", "+", "-", "/"},                                   // 15 / (7 - (1 + 1))                 → expected: 3
      {"2", "3", "11", "+", "5", "-", "*"},                                   // 2 * (3 + 11 - 5)                   → expected: 18
    };

    for (String[] testCase : testCases) {
      int result = sol.evalRPN(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}
