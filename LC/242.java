import java_helper.GeneralHelper;

import java.util.Arrays;

class Solution242 {
  public boolean isAnagram(String s, String t) {
    char[] sCharArray = s.toCharArray();
    char[] tCharArray = t.toCharArray();

    Arrays.sort(sCharArray);
    Arrays.sort(tCharArray);

    return Arrays.equals(sCharArray, tCharArray);
  }

  public static void main(String[] args) {
    Solution242 sol = new Solution242();

    String[][] testCases = {
      {"a", "a"},                                                           // single char, same
      {"a", "b"},                                                           // single char, different
      {"anagram", "nagaram"},                                               // classic anagram
      {"rat", "car"},                                                       // different letters
      {"listen", "silent"},                                                 // common example
      {"triangle", "integral"},                                             // longer valid anagram
      {"abcd", "dcbae"},                                                    // different lengths
      {"hello", "bello"},                                                   // same length, one letter differs
      {"xxyyzz", "zzxxyy"},                                                 // repeated characters
      {"aaabbbccc", "cbacbacba"},                                           // mixed order
      {"abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"},         // full alphabet reversed
      {"abcabcabc", "cbacbacba"},                                           // same frequency, same length
      {"abcabcabc", "abcabcab"},                                            // one char missing 
      {"aaaaaaaaaa", "aaaaaaaaab"},                                         // almost identical except last
      {"aaaaabbbbbcccccdddddeeeeefffff", "fffdddeeeebbbcccaaaffffbbdddee"}, // large-ish, valid anagram
    };
    
    for (String[] testCase : testCases) {
      boolean result = sol.isAnagram(testCase[0], testCase[1]);
      GeneralHelper.printResult(testCase[0], testCase[1], result);
    }
  }
}