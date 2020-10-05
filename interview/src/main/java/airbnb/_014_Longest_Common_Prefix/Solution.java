package airbnb._014_Longest_Common_Prefix;

import java.util.Arrays;

public class Solution {
  public String longestCommonPrefix(String[] strs) {
    int commonLen = 0;
    String res = "";
    if (strs == null || strs.length == 0) {
      return res;
    }
    final int maxLen = Arrays.stream(strs).min((a, b) -> Integer.compare(a.length(), b.length())).get().length();
    out:
    for (int i = 0; i < maxLen; i++) {
      final char target = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (target == strs[j].charAt(i)) {
          continue;
        }
        break out;
      }
      commonLen++;
    }
    return strs[0].substring(0, commonLen);
  }
}
