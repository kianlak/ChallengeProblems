import java.util.Stack;

import java_helper.GeneralHelper;

class Solution20 {
	public boolean isValid(String s) {
		Stack<Character> parenthesesStack = new Stack<>();

		char[] parenthesesArray = s.toCharArray();

		for (char character : parenthesesArray) {
			if (character == '(' || character == '{' || character == '[') {
				parenthesesStack.add(character);

				continue;
			}

			if (parenthesesStack.size() == 0) return false;
			
			switch(character) {
				case ')':
					if (parenthesesStack.pop() != '(') return false;
					break;
				case '}':
					if (parenthesesStack.pop() != '{') return false;
					break;
				case ']':
					if (parenthesesStack.pop() != '[') return false;
					break;
			}
		}

		return parenthesesStack.size() == 0 ? true : false;
	}

  public static void main(String[] args) {
    Solution20 sol = new Solution20();

		String[] testCases = {
			"()",                 // simple valid
			"()[]{}",             // multiple types
			"(]",                 // mismatch type
			"([)]",               // incorrect nesting
			"{[]}",               // correct nesting
			"((((()))))",         // deep nesting
			"(((",                // missing closing brackets
			")))",                // closing without opening
			"[",                  // single unclosed bracket
			"]",                  // single unmatched close
			"",                   // empty string
			"{[()()]}",           // complex valid
			"{[()()]]",           // extra closing bracket
			"([]{})",             // valid mixture
			"([{}]))",            // trailing mismatch
		};

		for (String testCase : testCases) {
			boolean result = sol.isValid(testCase);

      GeneralHelper.printResult(testCase, result);
    }
  }
}