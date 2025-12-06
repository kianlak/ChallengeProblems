import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import java_helper.GeneralHelper;

class Solution155 {
  class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
      mainStack = new Stack<>();
      minStack = new Stack<>();
    }
    
    public void push(int val) {
      mainStack.push(val);

      if (minStack.isEmpty()) minStack.push(val);
      else if (minStack.peek() >= val) minStack.push(val);
    }
    
    public void pop() {
      int val = mainStack.pop();
      
      if (minStack.peek() == val) minStack.pop();
    }
    
    public int top() {
      return mainStack.peek();
    }
    
    public int getMin() {
      return minStack.peek();
    }
  }

  public static void main(String[] args) {
    Solution155 sol = new Solution155();

    Object[][] testCases = {
      /*
       * basic example 
       * expected: 
       * [null,null,null,null,-3,null,0,-2]
       */
      {
        new String[]{"MinStack","push","push","push","getMin","pop","top","getMin"},
        new Object[]{null,-2,0,-3,null,null,null,null}
      },
      /*
       * pushing smaller then larger 
       * expected: 
       * [null,null,null,3,null,3,null,3]
       */
      {
        new String[]{"MinStack","push","push","getMin","push","getMin","pop","getMin"},
        new Object[]{null,5,3,null,7,null,null,null}
      },
      /*
       * duplicates removed after pops 
       * expected: 
       * [null,null,null,null,null,null,2]
       */
      {
        new String[]{"MinStack","push","push","push","pop","pop","getMin"},
        new Object[]{null,2,2,2,null,null,null}
      },
      /*
       * negative decreasing sequence
       * expected: 
       * [null,null,null,null,null,-7,null,-5]
       */
      {
        new String[]{"MinStack","push","push","push","push","getMin","pop","getMin"},
        new Object[]{null,-1,-3,-5,-7,null,null,null}
      },
      /*
       * top returns last inserted   
       * expected: 
       * [null,null,null,10,8]
       */
      {
        new String[]{"MinStack","push","push","top","getMin"},
        new Object[]{null,8,10,null,null}
      },
      /*
       * correct min after pop    
       * expected: 
       * [null,null,null,null,4]
       */
      {
        new String[]{"MinStack","push","push","pop","getMin"},
        new Object[]{null,4,1,null,null}
      },
      /*
       * pushing stack state maintained         
       * expected: 
       * [null,null,null,null,null, 50]
       */
      {
        new String[]{"MinStack","push","push","push","pop","top"},
        new Object[]{null,100,50,75,null,null}
      }   
    };

    for (Object[] testCase : testCases) {
      String[] operations = (String[]) testCase[0];
      Object[] values = (Object[]) testCase[1];

      MinStack stack = sol.new MinStack();
      List<String> output = new ArrayList<>();

      for (int i = 0; i < operations.length; i++) {
        String operation = operations[i];

        switch (operation) {
          case "MinStack":
            output.add("MinStack() → null");
            break;

          case "push":
            int v = (int) values[i];
            stack.push(v);
            output.add("push(" + v + ") → null");
            break;

          case "pop":
            stack.pop();
            output.add("pop() → null");
            break;

          case "top":
            output.add("top() → " + stack.top());
            break;

          case "getMin":
            output.add("getMin() → " + stack.getMin());
            break;
        }
      }

      GeneralHelper.printResultSpecialCaseLogsStackClass(output);
    }
  }
}