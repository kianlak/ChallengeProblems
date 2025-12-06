import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import java_helper.GeneralHelper;

class Solution1381 {
  class CustomStack {
    public Stack<Integer> stack = new Stack<Integer>();
    public int[] incrementation;
    public int maxSize;

    public CustomStack(int maxSize) {
      this.maxSize = maxSize;
      this.incrementation = new int[maxSize];
    }
    
    public void push(int x) {
      if (stack.size() != maxSize) stack.push(x);
    }
    
    public int pop() {
      if (stack.size() == 0) return -1;
      else {
        int currTopIndex = stack.size() - 1;
        int value = stack.pop() + incrementation[currTopIndex];
        incrementation[currTopIndex] = 0;

        return value;
      }
    }
    
    public void increment(int k, int val) {
      if (k > stack.size()) k = stack.size();

      for (int index = 0; index < k; index++) {
          incrementation[index] += val;
      }
    }
  }

  /**
   * Your CustomStack object will be instantiated and called as such:
   * CustomStack obj = new CustomStack(maxSize);
   * obj.push(x);
   * int param_2 = obj.pop();
   * obj.increment(k,val);
   */

  public static void main(String[] args) {
    Solution1381 sol = new Solution1381();

    Object[][] testCases = {
      // Basic push/pop sequence
      {
        new String[]{"CustomStack","push","push","pop","pop"},
        new Object[]{3, 1, 2, null, null}
      },

      // Push beyond maxSize (should ignore extra pushes)
      {
        new String[]{"CustomStack","push","push","push","push","pop","pop"},
        new Object[]{2, 1, 2, 3, 4, null, null}
      },

      // Increment k within bounds
      {
        new String[]{"CustomStack","push","push","increment","pop","pop"},
        new Object[]{2, 3, 4, new int[]{2, 3}, null, null}
      },

      // Increment k larger than stack size (should clamp)
      {
        new String[]{"CustomStack","push","push","increment","pop","pop"},
        new Object[]{2, 5, 6, new int[]{5, 3}, null, null}
      },

      // Multiple increments before any pops
      {
        new String[]{"CustomStack","push","push","push","increment","increment","pop","pop","pop"},
        new Object[]{3, 5, 10, 15, new int[]{3, 1}, new int[]{2, 5}, null, null, null}
      },

      // Pop from empty stack (should return -1)
      {
        new String[]{"CustomStack","pop","push","pop"},
        new Object[]{1, null, 7, null}
      },

      // Increment after some pops
      {
        new String[]{"CustomStack","push","push","push","pop","increment","pop","pop"},
        new Object[]{3, 5, 1, 2, null, new int[]{2,5}, null, null}
      },

      // Edge case: maxSize = 0 (stack cannot hold anything)
      {
        new String[]{"CustomStack","push","pop"},
        new Object[]{0, 10, null}
      },

      // Large increment parameter but small stack
      {
        new String[]{"CustomStack","push","push","increment","pop","pop"},
        new Object[]{2, 100, 101, new int[]{1000,4}, null, null}
      },

      // Complex alternating operations
      {
        new String[]{"CustomStack","push","push","push","increment","pop","increment","pop"},
        new Object[]{3, 5, 7, 9, new int[]{3,2}, null, new int[]{1,5}, null}
      }
    };

    for (Object[] testCase : testCases) {
      String[] operations = (String[]) testCase[0];
      Object[] values = (Object[]) testCase[1];

      CustomStack stack = null;
      List<String> output = new ArrayList<>();

      for (int i = 0; i < operations.length; i++) {
        String operation = operations[i];

        switch (operation) {
          case "CustomStack":
            int maxSize = (int) values[i];
            stack = sol.new CustomStack(maxSize);
            output.add("CustomStack(" + maxSize + ") → null");
            break;

          case "push":
            int v = (int) values[i];
            stack.push(v);
            output.add("push(" + v + ") → null");
            break;

          case "pop":
            int popped = stack.pop();
            output.add("pop() → " + popped);
            break;

          case "increment":
            int[] args2 = (int[]) values[i];
            int k = args2[0];
            int val = args2[1];
            stack.increment(k, val);
            output.add("increment(" + k + "," + val + ") → null");
            break;
        }
      }

      GeneralHelper.printResultSpecialCaseLogsStackClass(output);
    }
  }
}