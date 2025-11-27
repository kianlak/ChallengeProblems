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
      "A man, a plan, a canal: Panama",   // classic palindrome case                    → expected: true
      "racecar",                          // simple odd-length palindrome               → expected: true
      "abba",                             // simple even-length palindrome              → expected: true
      "abc",                              // clearly not a palindrome                   → expected: false
      " ",                                // single space (no alphanumerics)            → expected: true
      ".,!",                              // only punctuation characters                → expected: true
      "0P",                               // digit + letter, not equal after normalize  → expected: false
      "No 'x' in Nixon",                  // mixed case + punctuation                   → expected: true
      "Was it a car or a cat I saw?",     // full sentence palindrome                   → expected: true
      "Madam, I'm Adam",                  // another famous phrase                      → expected: true
      "hello",                            // regular word, not palindrome               → expected: false
      "aa",                               // minimal even palindrome                    → expected: true
      "a",                                // single character                           → expected: true
      "12321",                            // numeric palindrome                         → expected: true
      "1231",                             // numeric non-palindrome                     → expected: false
    };

    for (String testCase : testCases) {
      boolean result = sol.isPalindrome(testCase);

      GeneralHelper.printResult(testCase, result);
    }
  }
}
