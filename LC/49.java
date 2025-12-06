import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java_helper.GeneralHelper;

class Solution49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, Integer> anagramMappings = new HashMap<>();
    List<List<String>> anagrams = new ArrayList<>();

    char[] strsChars;

    for (int index = 0; index < strs.length; index++) {
      strsChars = strs[index].toCharArray();
      Arrays.sort(strsChars);

      String sortedString = new String(strsChars);

      if (!anagramMappings.containsKey(sortedString)) {
        List<String> newList = new ArrayList<>();
        newList.add(strs[index]);
        
        anagramMappings.put(sortedString, anagrams.size());
        anagrams.add(anagrams.size(), newList);
      } else {
        anagrams.get(anagramMappings.get(sortedString)).add(strs[index]);
      }
    }

    return anagrams;
  }


  public static void main(String[] args) {
    Solution49 sol = new Solution49();

    String[][] testCases = {
      new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},         // classic example
      new String[]{"abc", "bca", "cab", "xyz", "zyx"},                // multiple groups
      new String[]{"a"},                                              // single element
      new String[]{"", ""},                                           // empty strings are anagrams
      new String[]{"aa", "bb", "ab", "ba", "bba"},                    // mixed lengths
      new String[]{"listen", "silent", "enlist", "google", "gooegl"}, // two clear groups
      new String[]{"rat", "tar", "art", "star", "tars", "cheese"},    // 3-word anagram + 2-word anagram + single
      new String[]{"dddd", "dd", "d", "dddd", "dd"},                  // duplicates and different lengths
      new String[]{"noon", "onon", "nono", "abc", "cab"},             // 3-word group + 2-word group
      new String[]{"qwe", "ewq", "weq", "zzz", "zz", "z"}             // 3-word group + uniques
    };


    for (String[] testCase : testCases) {
      List<List<String>> result = sol.groupAnagrams(testCase);

      GeneralHelper.printResult(testCase, result);
    }
  }
}