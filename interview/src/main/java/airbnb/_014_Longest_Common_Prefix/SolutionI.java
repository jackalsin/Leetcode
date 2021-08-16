package airbnb._014_Longest_Common_Prefix;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    int maxCommonLen = 0;
    final int maxLen = Arrays.stream(strs).mapToInt(String::length).min().getAsInt();
    out:
    for (int i = 0; i < maxLen; ++i) {
      final char target = strs[0].charAt(i);
      for (int j = 1; j < strs.length; ++j) {
        if (strs[j].charAt(i) != target) break out;
      }
      maxCommonLen++;
    }
    return strs[0].substring(0, maxCommonLen);
  }
}
