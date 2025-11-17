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
			"()",                 // simple valid 						→ expected: true
			"()[]{}",             // multiple types 					→ expected: true
			"(]",                 // mismatch type 						→ expected: false
			"([)]",               // incorrect nesting 				→ expected: false
			"{[]}",               // correct nesting 					→ expected: true
			"((((()))))",         // deep nesting 						→ expected: true
			"(((",                // missing closing brackets → expected: false
			")))",                // closing without opening 	→ expected: false
			"[",                  // single unclosed bracket 	→ expected: false
			"]",                  // single unmatched close 	→ expected: false
			"",                   // empty string 						→ expected: true
			"{[()()]}",           // complex valid 						→ expected: true
			"{[()()]]",           // extra closing bracket 		→ expected: false
			"([]{})",             // valid mixture 						→ expected: true
			"([{}]))",            // trailing mismatch 				→ expected: false
		};

		for (String testCase : testCases) {
			boolean result = sol.isValid(testCase);

      GeneralHelper.printResult(testCase, result);
    }
  }
}