import java_helper.GeneralHelper;

class Solution125 {
  public boolean isPalindrome(String s) {
    int leftPointer = 0;
    int rightPointer = s.length() - 1;
    
    s = s.toLowerCase();
    
    while (leftPointer < rightPointer) {
      if (!Character.isLetterOrDigit(s.charAt(leftPointer))) {
        leftPointer++;
      } else if (!Character.isLetterOrDigit(s.charAt(rightPointer))) {
        rightPointer--;
      } else {
        if (s.charAt(leftPointer) != s.charAt(rightPointer)) return false;
        leftPointer++;
        rightPointer--;
      }
    }

    return true;
  }


  public static void main(String[] args) {
    Solution125 sol = new Solution125();

    String[] testCases = {
      "A man, a plan, a canal: Panama",   // classic palindrome case
      "racecar",                          // simple odd-length palindrome
      "abba",                             // simple even-length palindrome
      "abc",                              // clearly not a palindrome
      " ",                                // single space (no alphanumerics)
      ".,!",                              // only punctuation characters
      "0P",                               // digit + letter, not equal after normalize
      "No 'x' in Nixon",                  // mixed case + punctuation
      "Was it a car or a cat I saw?",     // full sentence palindrome
      "Madam, I'm Adam",                  // another famous phrase
      "hello",                            // regular word, not palindrome
      "aa",                               // minimal even palindrome
      "a",                                // single character
      "12321",                            // numeric palindrome
      "1231",                             // numeric non-palindrome
    };

    for (String testCase : testCases) {
      boolean result = sol.isPalindrome(testCase);

      GeneralHelper.printResult(testCase, result);
    }
  }
}
