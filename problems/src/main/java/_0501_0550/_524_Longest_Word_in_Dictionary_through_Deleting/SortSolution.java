package _0501_0550._524_Longest_Word_in_Dictionary_through_Deleting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class SortSolution implements Solution {
  @Override
  public String findLongestWord(String s, List<String> d) {
    Collections.sort(d, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
          return o1.compareTo(o2);
        }
        return Integer.compare(o2.length(), o1.length());
      }
    });
    for (String subStr : d) {
      int subPtr = 0;
      for (int sPtr = 0; sPtr < s.length(); sPtr++) {
        if (subPtr < subStr.length() && subStr.charAt(subPtr) == s.charAt(sPtr)) {
          subPtr++;
        }
      }
      if (subPtr == subStr.length()) {
        return subStr;
      }

    }
    return "";
  }
}
