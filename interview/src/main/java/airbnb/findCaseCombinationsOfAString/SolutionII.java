package airbnb.findCaseCombinationsOfAString;

import java.util.function.Function;

public final class SolutionII implements Solution {
  public boolean matchHiddenString(final String src, final Function<String, Boolean> f) {
    if (src == null || src.length() == 0) {
      return f.apply(src);
    }

    return dfs(new StringBuilder(src), 0, f);
  }

  private static boolean dfs(final StringBuilder sb, int i, Function<String, Boolean> f) {
    if (i == sb.length()) {
      return f.apply(sb.toString());
    }
    final char chr = sb.charAt(i);
    sb.setCharAt(i, Character.toUpperCase(chr));
    if (dfs(sb, i + 1, f)) {
      return true;
    }
    sb.setCharAt(i, Character.toLowerCase(chr));
    if (dfs(sb, i + 1, f)) {
      return true;
    }
    sb.setCharAt(i, chr);
    return false;
  }
}
