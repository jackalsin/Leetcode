package interviews.airbnb._756_Pyramid_Transition_Matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/11/2019.
 */
public final class NaiveSolution implements Solution {
  private static final int N = 26;
  private final boolean[][][] map = new boolean[N][N][N];
  private static final char BASE = 'A';
  private final Set<List<Character>> visited = new HashSet<>();

  @Override
  public boolean pyramidTransition(String bottom, List<String> allowed) {
    for (final String w : allowed) {
      map[w.charAt(0) - BASE][w.charAt(1) - BASE][w.charAt(2) - BASE] = true;
    }
    final List<Character> curLine = new ArrayList<>();
    for (final char chr : bottom.toCharArray()) {
      curLine.add(chr);
    }

    return dfs(curLine, new ArrayList<>(), 0);
  }

  private boolean dfs(final List<Character> curLine, final List<Character> nextLine, final int i) {
    if (curLine.size() == 1) {
      return true;
    }

    if (nextLine.size() == curLine.size() - 1) {
      if (visited.contains(nextLine)) {
        return false;
      }
      final boolean res = dfs(nextLine, new ArrayList<>(), 0);
      if (!res) {
        visited.add(nextLine);
      }
      return res;
    }
    final char chr1 = curLine.get(i), chr2 = curLine.get(i + 1);

    for (char chr = 'A'; chr <= 'Z'; chr++) {
      if (map[chr1 - 'A'][chr2 - 'A'][chr - 'A']) {
        nextLine.add(chr);
        if (dfs(curLine, nextLine, i + 1)) {
          return true;
        }
        nextLine.remove(nextLine.size() - 1);
      }
    }
    return false;
  }
}
