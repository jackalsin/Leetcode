package _1901_1950._1923_Longest_Common_Subpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  private static final long MOD = (int) (1E9 + 7),
      PRIME = 100001;

  public int longestCommonSubpath(int n, int[][] paths) {
    int left = 0, right = minLen(paths);
    while (left < right) {
      final int m = left + (right - left + 1) / 2;
      Map<Long, List<Integer>> subPathHash = new HashMap<>();
//      System.out.println("m = " + m);
      for (int k = 0; k < paths.length; ++k) {
        final int[] path = paths[k];
        final Map<Long, List<Integer>> cur = new HashMap<>();
        long hash = 0, d = 1;
        nextPosition:
        for (int i = 0; i < path.length; ++i) {
          hash = (hash * PRIME + path[i]) % MOD;
          if (i >= m) {
            hash = (MOD + hash - d * path[i - m] % MOD) % MOD;
          } else {
            d = d * PRIME % MOD;
          }
          if (i >= m - 1) {
            if (k == 0) {
              assert subPathHash.isEmpty();
              cur.computeIfAbsent(hash, key -> new ArrayList<>()).add(i);
            } else if (subPathHash.containsKey(hash)) {
              final List<Integer> existingPath = subPathHash.get(hash);
              for (int x = existingPath.get(0), y = i; y > i - m; --y, --x) {
                if (paths[0][x] != path[y]) break nextPosition;
              }
              cur.computeIfAbsent(hash, key -> new ArrayList<>()).add(existingPath.get(0));
            }
          }

        }
        subPathHash = cur;
//        System.out.println("m = " + m + ", subPathHash = " + subPathHash);
        if (subPathHash.isEmpty()) break;
      }
      if (subPathHash.isEmpty()) {
        right = m - 1;
      } else {
        left = m;
      }
    }
    return left;
  }

  private static int minLen(int[][] paths) {
    int minLen = paths[0].length;
    for (int i = 1; i < paths.length; ++i) {
      minLen = Math.min(minLen, paths[i].length);
    }
    return minLen;
  }

}
