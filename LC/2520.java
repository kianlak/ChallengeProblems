import java_helper.GeneralHelper;

class Solution2520 {
  public int countDigits(int num) {
    int result = 0;
    int originalNum = num;

    while (num != 0) {
      int val = num % 10;

      if (originalNum % val == 0) result++;

      num /= 10;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution2520 sol = new Solution2520();

    int[] testCases = {
      1,        // minimum input, single digit
      7,        // single-digit, self-dividing 
      22,       // repeated digit 2 
      121,      // only 1’s divide   
      1248,     // all digits divide 
      135,      // all divide 135  
      999,      // all digits 9, divide 999  
      12345,    // only 1,3,5 divide 
      987654321 // large near upper bound 
    };

    for (int testCase : testCases) {
      int result = sol.countDigits(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}