import java.util.ArrayList;
import java.util.List;

import java_helper.GeneralHelper;

class Solution119 {
  public List<Integer> getRow(int rowIndex) {
      List<List<Integer>> result = new ArrayList<>();

      for (int row = 0; row <= rowIndex; row++) {
          List<Integer> rowVals = new ArrayList<>();

          for (int index = 0; index <= row; index++) {
              if (index == 0 || index == row) rowVals.add(1);
              else {
                  List<Integer> prevRow = result.get(row - 1);
                  rowVals.add(prevRow.get(index - 1) + prevRow.get(index));
              }
          }

          result.add(rowVals);
      }

      return result.get(rowIndex);
  }

  public static void main(String[] args) {
    Solution119 sol = new Solution119();

    int[] testCases = {
      0,  // smallest row (single element)
      1,  // second row
      2,  // adds one middle element
      3,  // example from problem statement
      4,  // verify correct middle coefficients
      5,  // check growing row size
      10, // medium-depth row, test iteration correctness
      20, // large input, performance and accuracy validation
      33  // upper constraint bound (0 ≤ rowIndex ≤ 33)
    };

    for (int testCase : testCases) {
      List<Integer> result = sol.getRow(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}
