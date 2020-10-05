package airbnb._756_Pyramid_Transition_Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/11/2019.
 */
public final class DpSolution implements Solution {
  private static final int N = 7;
  private static final char A = 'A';
  private boolean[][][] validMap;
  private final Map<List<Character>, Boolean> cache = new HashMap<>();

  public boolean pyramidTransition(String bottom, List<String> allowed) {
    validMap = new boolean[N][N][N];
    for (String word : allowed) {
      validMap[word.charAt(0) - A][word.charAt(1) - A][word.charAt(2) - A] = true;
    }

    final List<Character> path = new ArrayList<>();
    for (char chr : bottom.toCharArray()) {
      path.add(chr);
    }
    return dfs(new ArrayList<>(), path, 1);
  }

  private boolean dfs(final List<Character> curPath, final List<Character> bottom, int start) {
    assert !bottom.isEmpty();
    if (start == 1 && cache.containsKey(curPath)) {
      return cache.get(curPath);
    }
    if (bottom.size() == 1) {
      return true;
    } else if (bottom.size() == curPath.size() + 1) {
      final boolean res = dfs(new ArrayList<>(), curPath, 1);
      cache.put(new ArrayList<>(curPath), res);
      return res;
    }
    final boolean[] candidates = validMap[bottom.get(start - 1) - A][bottom.get(start) - A];
    for (int i = 0; i < N; i++) {
      if (candidates[i]) {
        final char chr = (char) (i + A);
        curPath.add(chr);
        if (dfs(curPath, bottom, start + 1)) {
          cache.put(new ArrayList<>(bottom), true);
          return true;
        }
        curPath.remove(curPath.size() - 1);
      }
    }
    cache.put(new ArrayList<>(bottom), false);
    return false;
  }
}
