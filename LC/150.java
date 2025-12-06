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
      {"2", "1", "+", "3", "*"},                                              // (2 + 1) * 3
      {"4", "13", "5", "/", "+"},                                             // 4 + (13 / 5)
      {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"},  // complex long expression
      {"18"},                                                                 // single value
      {"3", "4", "-"},                                                        // 3 - 4
      {"5", "1", "2", "+", "4", "*", "+", "3", "-"},                          // classic: 5 + ((1 + 2) * 4) - 3
      {"7", "2", "/"},                                                        // integer division
      {"-4", "2", "/"},                                                       // negative integer division
      {"0", "3", "/"},                                                        // zero numerator
      {"5", "9", "*"},                                                        // 5 * 9
      {"15", "7", "1", "1", "+", "-", "/"},                                   // 15 / (7 - (1 + 1))
      {"2", "3", "11", "+", "5", "-", "*"},                                   // 2 * (3 + 11 - 5)
    };

    for (String[] testCase : testCases) {
      int result = sol.evalRPN(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}
