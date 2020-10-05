package airbnb.findCaseCombinationsOfAString;

import java.util.function.Function;

public final class SolutionI implements Solution {
  public boolean matchHiddenString(final String src, final Function<String, Boolean> f) {
    if (src == null) {
      return false;
    }
    if (src.length() == 0) {
      return f.apply(src);
    }

    final StringBuilder sb = new StringBuilder();

    return dfs(src, sb, 0, f);

  }

  private static boolean dfs(final String src, final StringBuilder sb, final int i, final Function<String, Boolean> f) {
    if (sb.length() == src.length()) {
      System.out.println(sb);
      return f.apply(sb.toString());
    }
    final char chr = src.charAt(i);
    sb.append(Character.toUpperCase(chr));
    if (dfs(src, sb, i + 1, f)) {
      return true;
    }
    sb.setCharAt(i, Character.toLowerCase(chr));
    if (dfs(src, sb, i + 1, f)) {
      return true;
    }
    sb.setLength(i);
    return false;
  }
}
