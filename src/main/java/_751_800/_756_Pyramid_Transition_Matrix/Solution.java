package _751_800._756_Pyramid_Transition_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/6/2018.
 */
public class Solution {
  private static final int N = 7;
  private static final char A = 'A';

  public boolean pyramidTransition(String bottom, List<String> allowed) {
    final boolean[][][] validMap = new boolean[N][N][N];
    for (final String word : allowed) {
      validMap[word.charAt(0) - A][word.charAt(1) - A][word.charAt(2) - A] = true;
    }
    final List<Character> path = new ArrayList<>();
    for (char chr : bottom.toCharArray()) {
      path.add(chr);
    }
    return helper(new ArrayList<>(), path, validMap, 1);
  }

  private static boolean helper(final List<Character> curPath, final List<Character> bottom,
                                final boolean[][][] validMap, int start) {
    if (bottom.size() == 1) {
      return true;
    } else if (bottom.size() == curPath.size() + 1) {
      return helper(new ArrayList<>(), curPath, validMap, 1);
    }
    assert start != 0;
    final boolean[] candidates = validMap[bottom.get(start - 1) - A][bottom.get(start) - A];
    for (int i = 0; i < N; i++) {
      if (candidates[i]) {
        curPath.add((char) ((char) i + 'A'));
        if (helper(curPath, bottom, validMap, start + 1)) {
          return true;
        }
        curPath.remove(curPath.size() - 1);
      }
    }
    return false;
  }
}
