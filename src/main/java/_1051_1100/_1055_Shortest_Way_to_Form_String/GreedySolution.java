package _1051_1100._1055_Shortest_Way_to_Form_String;

import java.util.HashSet;
import java.util.Set;

public final class GreedySolution implements Solution {
  /**
   * Time Complexity: O(source.length * target.length())
   * Space Complexity: O(source.length)
   *
   * @param source
   * @param target
   * @return
   */
  @Override
  public int shortestWay(String source, String target) {
    assert source.length() >= 1 && source.length() <= 1000
        && target.length() >= 1 && target.length() <= 1000;

    final Set<Character> charsInSource = new HashSet<>();
    for (char chr : source.toCharArray()) {
      charsInSource.add(chr);
    }

    for (char chr : target.toCharArray()) {
      if (!charsInSource.contains(chr)) return -1;
    }
    int step = 0;
    for (int i = 0, j = 0; j < target.length(); ) {
      if (i == 0) step++;
      final char srcChar = source.charAt(i),
          tgtChar = target.charAt(j);
      if (srcChar == tgtChar) j++;
      i++;
      if (i == source.length()) {
        i = 0;
      }
    }
    return step;
  }
}
