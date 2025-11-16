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
      {"a", "a"},                               // single char, same                → expected: true
      {"a", "b"},                               // single char, different           → expected: false
      {"anagram", "nagaram"},                   // classic anagram                  → expected: true
      {"rat", "car"},                           // different letters                → expected: false
      {"listen", "silent"},                     // common example                   → expected: true
      {"triangle", "integral"},                 // longer valid anagram             → expected: true
      {"abcd", "dcbae"},                        // different lengths                → expected: false
      {"hello", "bello"},                       // same length, one letter differs  → expected: false
      {"xxyyzz", "zzxxyy"},                     // repeated characters              → expected: true
      {"aaabbbccc", "cbacbacba"},               // mixed order                      → expected: true
      {"abcdefghijklmnopqrstuvwxyz", 
      "zyxwvutsrqponmlkjihgfedcba"},            // full alphabet reversed           → expected: true
      {"abcabcabc", "cbacbacba"},               // same frequency, same length      → expected: true
      {"abcabcabc", "abcabcab"},                // one char missing                 → expected: false
      {"aaaaaaaaaa", "aaaaaaaaab"},             // almost identical except last     → expected: false
      {"aaaaabbbbbcccccdddddeeeeefffff", 
      "fffdddeeeebbbcccaaaffffbbdddee"},        // large-ish, valid anagram         → expected: true
    };
    
    for (String[] testCase : testCases) {
      boolean result = sol.isAnagram(testCase[0], testCase[1]);
      GeneralHelper.printResult(testCase[0], testCase[1], result);
    }
  }
}