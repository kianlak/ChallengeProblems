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
      /* square 3x3
       * expected: 
       * [[1,4,7],
       *  [2,5,8],
       *  [3,6,9]]
       */
			{
        {1,2,3},
        {4,5,6},
        {7,8,9}
      },
      /* rectangular 2x3 
       * expected: 
       * [[1,4],
       *  [2,5],
       *  [3,6]]
       */
      {
        {1,2,3},
        {4,5,6}
      },
      /* rectangular 3x2
       * expected: 
       * [[1,3,5],
       *  [2,4,6]]
      */            
      {
        {1,2},
        {3,4},
        {5,6}
      },
      /* 1x1
       * expected: [[42]]
       */
      {{42}},
      /* single row (1x4)
       * expected: 
       * [[1],
       *  [2],
       *  [3],
       *  [4]]
       */
      {
        {1,2,3,4}
      },
      /* single column (4x1) 
       * expected: 
       * [[1,2,3,4]]
      */
      {
        {1},
        {2},
        {3},
        {4}
      },
      /*
       * negatives
       * expected: 
       * [[-1,-3],
       *  [-2,-4]]
       */
      {
        {-1,-2},
        {-3,-4}
      },
      /* large values (within bounds)
       * expected: 
       * [[1000000000],
       *  [-1000000000]]
       */
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