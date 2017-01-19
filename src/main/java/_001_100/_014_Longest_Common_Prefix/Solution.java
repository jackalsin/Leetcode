package _001_100._014_Longest_Common_Prefix;

/**
 * @author jacka
 * @version 1.0 on 2017/1/19.
 */
public class Solution {
  /**
   * Write a function to find the longest common prefix string amongst an array of strings.
   *
   * @param strs an array of { @code String }
   * @return the longest common prefix (when nothing in
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null) {
      throw new NullPointerException();
    } else if (strs.length == 0) {
      return "";
    } else {
      StringBuilder sb = new StringBuilder();
      int i = 0;
      if (strs[0].isEmpty()) {
        return "";
      }
      while (true) {
        if (i >= strs[0].length()) {
          return sb.toString();
        }
        char toCompare = strs[0].charAt(i);
        for (int j = 0; j < strs.length; j++) {
          if (i < strs[j].length() && strs[j].charAt(i) == toCompare) {
            if (j == strs.length - 1) {
              sb.append(toCompare);
            }
          } else {
            return sb.toString();
          }
        }
        i++;
      }
    }
  }
}
