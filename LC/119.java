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
      0,  // smallest row (single element)                       → expected: [1]
      1,  // second row                                          → expected: [1, 1]
      2,  // adds one middle element                             → expected: [1, 2, 1]
      3,  // example from problem statement                      → expected: [1, 3, 3, 1]
      4,  // verify correct middle coefficients                  → expected: [1, 4, 6, 4, 1]
      5,  // check growing row size                              → expected: [1, 5, 10, 10, 5, 1]
      10, // medium-depth row, test iteration correctness        → expected: [1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1]
      20, // large input, performance and accuracy validation    → expected: [1, 20, 190, 1140, 4845, 15504, 38760, 77520, 125970, 167960, 184756, 167960, 125970, 77520, 38760, 15504, 4845, 1140, 190, 20, 1]
      33  // upper constraint bound (0 ≤ rowIndex ≤ 33)          → expected: [1, 33, 528, 5456, 40920, 237336, 1107568, 4272048, 13884156, 38567100, 92561040, 193536720, 354817320, 573166440, 818809200, 1037158320, 1166803110, 1166803110, 1037158320, 818809200, 573166440, 354817320, 193536720, 92561040, 38567100, 13884156, 4272048, 1107568, 237336, 40920, 5456, 528, 33, 1]
    };

    for (int testCase : testCases) {
      List<Integer> result = sol.getRow(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}
