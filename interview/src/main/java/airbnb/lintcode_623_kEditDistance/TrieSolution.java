package airbnb.lintcode_623_kEditDistance;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/k-edit-distance/description
 */
public final class TrieSolution implements Solution {
  private final Node root = new Node();

  /**
   * @param words:  a set of string candidates
   * @param target: a target string
   * @param k:      An integer
   * @return: output all the strings that meet the requirements
   */
  public List<String> kDistance(String[] words, String target, int k) {
    // write your code here
    final List<String> result = new ArrayList<>();
    if (words == null) {
      return result;
    }
    for (String str : words) {
      insert(root, str, 0);
    }
    final int[] distance = new int[target.length() + 1];
    for (int i = 0; i < distance.length; i++) {
      distance[i] = i;
    }
    dfs(result, root, target, k, distance, new StringBuilder());
    return result;
  }

  private static void dfs(final List<String> result, final Node root, final String target, final int k, int[] preDist,
                          final StringBuilder curPath) {
    assert root != null;
    if (root.word != null) {
      if (preDist[target.length()] <= k) {
        result.add(curPath.toString());
      }
    }

    for (int i = 0; i < 26; i++) {
      if (root.next[i] == null) {
        continue;
      }

      final int[] curDist = new int[target.length() + 1];
      curDist[0] = preDist[0] + 1; // curDistance[curPath.length()] = 0
      for (int j = 1; j < preDist.length; j++) {
        if (target.charAt(j - 1) == (char) (i + 'a')) {
          curDist[j] = preDist[j - 1];
        } else {
          // replace  dp[i - 1][j - 1] + 1    preDist[j - 1]
          // insert   dp[i - 1][j] + 1        preDist[j]
          // delete   dp[i][j - 1] + 1        curDist[j - 1]
          curDist[j] = Math.min(preDist[j], Math.min(preDist[j - 1], curDist[j - 1])) + 1;
        }
      }
      final int len = curPath.length();
      curPath.append((char) (i + 'a'));
      dfs(result, root.next[i], target, k, curDist, curPath);
      curPath.setLength(len);
    }
  }

  private static void insert(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, i + 1);
  }

  private static final class Node {
    private String word;
    private final Node[] next = new Node[26];
  }
}
