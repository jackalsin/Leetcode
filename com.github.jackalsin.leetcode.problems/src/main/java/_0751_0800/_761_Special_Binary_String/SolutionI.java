package _0751_0800._761_Special_Binary_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String makeLargestSpecial(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    int count = 0;
    final int n = s.length();
    final List<String> result = new ArrayList<>();
    for (int i = 0, j = 0; j < n; ++j) {
      final char chr = s.charAt(j);
      if (chr == '1') {
        count++;
      } else {
        count--;
      }
      /*
        1) The number of 0's is equal to the number of 1's.
        2) Every prefix of the binary string has at least as many 1's as 0's.
        那么如果一个special string被去掉一个special string 的 prefix， 剩下部分仍然是special string
      */
      if (count == 0) {
        result.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
        i = j + 1;
      }
    }
    result.sort(Collections.reverseOrder());
    return String.join("", result);
  }
}
