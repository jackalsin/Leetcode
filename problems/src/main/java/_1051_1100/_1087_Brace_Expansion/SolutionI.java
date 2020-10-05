package _1051_1100._1087_Brace_Expansion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String[] expand(String S) {
    if (S == null || S.isEmpty()) {
      return new String[0];
    }
    List<String> result = new ArrayList<>() {{
      add("");
    }};
    int start = -1;
    for (int i = 0; i < S.length(); ++i) {
      final char chr = S.charAt(i);
      if (chr == '{') {
        start = i;
      } else if (chr == '}') {
        final String[] append = S.substring(start + 1, i).split(",");
        result = getNext(result, append);
        start = -1;
      } else if (start == -1 && Character.isLetter(chr)) {
        result = getNext(result, String.valueOf(chr));
      }
    }
    Collections.sort(result);
    return result.toArray(new String[0]);
  }

  private static List<String> getNext(final List<String> srcList, final String append) {
    return getNext(srcList, new String[]{append});
  }

  private static List<String> getNext(final List<String> srcList, final String[] append) {
    final List<String> result = new ArrayList<>();
    for (final String src : srcList) {
      for (final String c : append) {
        result.add(src + c);
      }
    }
    return result;
  }
}
