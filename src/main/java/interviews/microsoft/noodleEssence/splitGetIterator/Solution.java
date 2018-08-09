package interviews.microsoft.noodleEssence.splitGetIterator;

import java.util.HashSet;
import java.util.Set;

public final class Solution {
  private String str;
  private int start = 0;

  public String get(final String sep, final String input) {
    if (input != null) {
      start = 0;
      this.str = input;
    }

    if (start == str.length()) {
      throw new IndexOutOfBoundsException(str + ", i = " + start);
    }
    final Set<Character> seps = new HashSet<>();
    for (final char chr : sep.toCharArray()) {
      seps.add(chr);
    }
    for (int i = start; i < str.length(); i++) {
      if (seps.contains(str.charAt(i))) {
        final String res = str.substring(start, i);
        start = i + 1;
        return res;
      }
    }
    // loop到最后
    final String res = str.substring(start);
    start = str.length();
    return res;
  }

}
