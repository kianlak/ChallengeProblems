import java_helper.GeneralHelper;

class Solution867 {
	public int[][] transpose(int[][] matrix) {
    int[][] newMatrix = new int[matrix[0].length][matrix.length];

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        newMatrix[col][row] = matrix[row][col];
      }
    }

    return newMatrix;
  }

  public static void main(String[] args) {
    Solution867 sol = new Solution867();
		
    int[][][] testCases = {
      // square 3x3
			{
        {1,2,3},
        {4,5,6},
        {7,8,9}
      },
      // rectangular 2x3
      {
        {1,2,3},
        {4,5,6}
      },
      // rectangular 3x2           
      {
        {1,2},
        {3,4},
        {5,6}
      },
      // 1x1
      {{42}},
      // single row (1x4)
      {
        {1,2,3,4}
      },
      // single column (4x1)
      {
        {1},
        {2},
        {3},
        {4}
      },
      // negatives
      {
        {-1,-2},
        {-3,-4}
      },
      // large values (within bounds)
      {
        {1000000000,
        -1000000000}
      },
    };

    for (int[][] testCase : testCases) {
      int[][] result = sol.transpose(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}