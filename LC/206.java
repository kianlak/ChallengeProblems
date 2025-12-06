import data_structure.DataStructureBuilder;
import data_structure.ListNode;
import java_helper.GeneralHelper;

class Solution206 {
  public ListNode reverseList(ListNode head) {
    ListNode result = null;
    ListNode currPointer = head;

    while (currPointer != null) {
      ListNode tempPointer = currPointer.next;
      currPointer.next = result;
      result = currPointer;
      currPointer = tempPointer;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution206 sol = new Solution206();

    int[][] testCases = {
      {1, 2, 3, 4, 5},      // standard increasing list
      {1},                  // single element list
      {},                   // empty list
      {2, 1},               // simple two-element reverse
      {1, 1, 1},            // all duplicates
      {-1, -2, -3},         // negative values
      {10, -5, 0, 10},      // mixed values with duplicates
      {100},                // another single-value case
      {9, 8, 7, 6},         // decreasing list
      {0, 0, 1, 0},         // zeros with one non-zero
    };

    for (int[] testCaseArr : testCases) {
      ListNode testCase  = DataStructureBuilder.buildListNode(testCaseArr);
      ListNode result   = sol.reverseList(DataStructureBuilder.buildListNode(testCaseArr));

      GeneralHelper.printResult(testCase, result);
    }
  }
}