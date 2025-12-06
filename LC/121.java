import java_helper.GeneralHelper;

class Solution121 {
  public int maxProfit(int[] prices) {
    int maxPrice = 0, minPrice = Integer.MAX_VALUE;
    
    for (int index = 0; index < prices.length; index++) {
      if (prices[index] > minPrice) maxPrice = Math.max(prices[index] - minPrice, maxPrice);
      else if (prices[index] < minPrice) minPrice = prices[index];
    }

    return maxPrice;
  }

  public static void main(String[] args) {
    Solution121 sol = new Solution121();

    int[][] testCases = {
      {7, 1, 5, 3, 6, 4},            // normal fluctuating prices
      {7, 6, 4, 3, 1},               // strictly decreasing (no profit)
      {1, 2, 3, 4, 5},               // strictly increasing
      {2, 4, 1},                     // small dip then rise
      {3, 3, 3},                     // flat prices
      {1},                           // single element
      {1, 2},                        // smallest profitable case
      {2, 1, 2, 1, 2},               // multiple valleys and peaks
      {9, 7, 2, 10, 1, 5, 6},        // multiple buy low / sell high points
      {100, 180, 260, 310, 40, 535}, // large rise then huge dip then spike
      {3, 8, 8, 55, 38, 1, 7, 42},   // classic value swing
    };

    for (int[] testCase : testCases) {
      int result = sol.maxProfit(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}
