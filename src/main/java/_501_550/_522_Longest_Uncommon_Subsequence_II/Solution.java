package _501_550._522_Longest_Uncommon_Subsequence_II;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public int findLUSlength(String[] strs) {
    if (strs == null || strs.length == 0) {
      return 0;
    }
    Arrays.sort(strs, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
      }
    });
    System.out.println(Arrays.toString(strs));
    for (int i = 0; i < strs.length; i++) {
      boolean isSubOfAny = false;
      for (int j = 0; j < strs.length; j++) {
        if (i != j && isSub(strs[i], strs[j])) {
          isSubOfAny = true;
          break;
        }
      }
      if (!isSubOfAny) {
        return strs[i].length();
      }

    }
    return -1;
  }

  /**
   * Return true if <code>a</code> is the substring of <code>b</code>
   *
   * @param a
   * @param b
   * @return
   */
  static boolean isSub(String a, String b) {
    int i = 0;
    for (int j = 0; j < b.length(); j++) {
      if (i < a.length() && a.charAt(i) == b.charAt(j)) {
        i++;
      }
    }
    return i == a.length();
  }
}
