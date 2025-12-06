import java.util.ArrayList;
import java.util.List;

import java_helper.GeneralHelper;

class Solution118 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    for (int row = 0; row < numRows; row++) {
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

    return result;
  }

  public static void main(String[] args) {
    Solution118 sol = new Solution118();

    int[] testCases = {
      1,  // minimum input, single row
      2,  // small triangle (2 rows) 
      5,  // typical case (5 rows)
      10, // 10 rows
      20, // 20 rows
      30  // upper bound
    };

    for (int testCase : testCases) {
      List<List<Integer>> result = sol.generate(testCase);
      GeneralHelper.printResultSpecialCasePyramid(testCase, result);
    }
  }
}