package interviews.linkedin.mianjing._294_Flip_Game_II;

import java.util.HashMap;
import java.util.Map;

public final class DfsMemoSolution implements Solution {

  public boolean canWin(String s) {
    if (s == null || s.length() < 2) {
      return false;
    }
    final Map<String, Boolean> cache = new HashMap<>();
    return dfs(cache, s);
  }

  private static boolean dfs(final Map<String, Boolean> cache, final String s) {
    if (cache.containsKey(s)) {
      return cache.get(s);
    }

    for (int i = 0; i < s.length() - 1; ++i) {
      if (s.startsWith("++", i)) {
        final String nextString = s.substring(0, i) + "--" + s.substring(i + 2);
        if (!dfs(cache, nextString)) { // 对手有机会输，我就能赢
          cache.put(s, true);
          return true;
        }
      }
    }
    cache.put(s, false);
    return false;
  }

}
