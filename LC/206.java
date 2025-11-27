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
      {1, 2, 3, 4, 5},      // standard increasing list           → expected: [5, 4, 3, 2, 1]
      {1},                  // single element list                → expected: [1]
      {},                   // empty list                         → expected: []
      {2, 1},               // simple two-element reverse         → expected: [1, 2]
      {1, 1, 1},            // all duplicates                     → expected: [1, 1, 1]
      {-1, -2, -3},         // negative values                    → expected: [-3, -2, -1]
      {10, -5, 0, 10},      // mixed values with duplicates       → expected: [10, 0, -5, 10]
      {100},                // another single-value case          → expected: [100]
      {9, 8, 7, 6},         // decreasing list                    → expected: [6, 7, 8, 9]
      {0, 0, 1, 0},         // zeros with one non-zero            → expected: [0, 1, 0, 0]
    };

    for (int[] testCaseArr : testCases) {
      ListNode testCase  = DataStructureBuilder.buildListNode(testCaseArr);
      ListNode result   = sol.reverseList(DataStructureBuilder.buildListNode(testCaseArr));

      GeneralHelper.printResult(testCase, result);
    }
  }
}