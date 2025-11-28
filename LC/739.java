import java.util.Stack;

import java_helper.GeneralHelper;

class Solution739 {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> tempToBeChecked = new Stack<>();

    int[] result = new int[temperatures.length];

    for (int currDay = 0; currDay < temperatures.length; currDay++) {
      while (!tempToBeChecked.isEmpty()) {
        if (temperatures[currDay] > temperatures[tempToBeChecked.peek()]) {
          int day = tempToBeChecked.pop();
          result[day] = currDay - day;
        } else {
          break;
        }
      }

      tempToBeChecked.push(currDay);
    }

    return result;
  }

  public static void main(String[] args) {
    Solution739 sol = new Solution739();

    int[][] testCases = {
      {73, 74, 75, 71, 69, 72, 76, 73},     // mixed temps                    → expected: [1,1,4,2,1,1,0,0]
      {30, 40, 50, 60},                     // strictly increasing            → expected: [1,1,1,0]
      {60, 50, 40, 30},                     // strictly decreasing            → expected: [0,0,0,0]
      {30, 30, 30},                         // all same                       → expected: [0,0,0]
      {50},                                 // single temperature             → expected: [0]
      {55, 50, 55},                         // drop then rise                 → expected: [0,1,0]
      {70, 71, 70, 69, 72},                 // drop then rise at end          → expected: [1,3,2,1,0]
      {80, 79, 78, 77, 90},                 // last temp is warmest           → expected: [4,3,2,1,0]
      {65, 60, 70, 55, 80},                 // multiple patterns              → expected: [2,1,2,1,0]
      {90, 60, 90},                         // equal temps separated          → expected: [0,1,0]
      {45, 50, 55, 53, 54, 56},             // slight dip before rising       → expected: [1,1,3,1,1,0]
      {100, 80, 60, 70, 90, 85},            // complex pattern                → expected: [0,3,1,1,0,0]
    };

    for (int[] testCase : testCases) {
      int[] result = sol.dailyTemperatures(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}