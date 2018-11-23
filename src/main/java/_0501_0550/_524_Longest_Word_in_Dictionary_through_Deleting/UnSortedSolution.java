package _0501_0550._524_Longest_Word_in_Dictionary_through_Deleting;

import java.util.List;

public final class UnSortedSolution implements Solution {

  @Override
  public String findLongestWord(String s, List<String> d) {
    String candidate = "";
    for (String subStr : d) {
      int subPtr = 0;
      for (int sPtr = 0; sPtr < s.length(); sPtr++) {
        if (subPtr < subStr.length() && subStr.charAt(subPtr) == s.charAt(sPtr)) {
          subPtr++;
        }

      }
      if (subPtr == subStr.length()) {
        if (candidate.length() < subStr.length()) {
          candidate = subStr;
        } else if (candidate.length() == subStr.length() && candidate.compareTo(subStr) > 0) {
          candidate = subStr;
        }
      }
    }
    return candidate;
  }
}
