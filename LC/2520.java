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
}