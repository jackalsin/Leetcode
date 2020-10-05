package _0301_0350._336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * O (N ^2) Solution
 * @author Zhiwei.Xin
 * @version 1.0 on 10/4/2017.
 */
public class MapSolution implements Solution {
  @Override
  public List<List<Integer>> palindromePairs(String[] words) {
    final List<List<Integer>> result = new ArrayList<>();
    final Map<String, Integer> stringToIndex = new HashMap<>();
    for (int i = 0; i < words.length; ++i) stringToIndex.put(words[i], i); // O(N)
    for (int i = 0; i < words.length; ++i) { // O(N)
      for (int j = 0; j <= words[i].length(); j++) { // O(k)
        String str1 = words[i].substring(0, j);
        String str2 = words[i].substring(j);
        if (isPalindrome(str1)) { //O(k)
          String remain = new StringBuilder().append(str2).reverse().toString();
          if (stringToIndex.containsKey(remain) && stringToIndex.get(remain) != i) {
            result.add(Arrays.asList(stringToIndex.get(remain), i));
          }
        }

        if (!str2.isEmpty() && isPalindrome(str2)) {
          String remain = new StringBuilder().append(str1).reverse().toString();
          if (stringToIndex.containsKey(remain) && stringToIndex.get(remain) != i) {
            result.add(Arrays.asList(i, stringToIndex.get(remain)));
          }
        }

      }
    }
    return result;
  }

  private boolean isPalindrome(String str1) {
    int i = 0, j = str1.length() - 1;
    while (i < j) {
      if (str1.charAt(i) != str1.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }
}
