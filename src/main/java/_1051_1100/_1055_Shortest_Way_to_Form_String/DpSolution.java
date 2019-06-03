package _1051_1100._1055_Shortest_Way_to_Form_String;

import java.util.Arrays;

public final class DpSolution implements Solution {
  private static final int N = 26;
  private final Node root = new Node();

  public int shortestWay(String source, String target) {
    assert source.length() >= 1 && source.length() <= 1000
        && target.length() >= 1 && target.length() <= 1000;

    // generate all sub-sequence of source, reversely insert to trie
    // inverse dp from the end of target
    insertAllSubsequence(source, new StringBuilder(), 0);

    final int[] dp = new int[target.length() + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[target.length()] = 0;
    for (int lastEnd = target.length(); lastEnd > 0; lastEnd--) {
      update(root, target, dp, lastEnd);
    }
    return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
  }

  private void update(Node root, final String target, final int[] dp, final int lastEnd) {
    if (dp[lastEnd] == Integer.MAX_VALUE) return;
    for (int i = lastEnd - 1; i >= 0; i--) {
      final char chr = target.charAt(i);
      final int chrIndex = chr - 'a';
      if (root.next[chrIndex] == null) {
        return;
      }
      dp[i] = Math.min(dp[i], dp[lastEnd] + 1);
      root = root.next[chrIndex];
      assert root.isWord;
    }
  }

  private void insertAllSubsequence(final String source, final StringBuilder curPath, final int i) {
    if (i == source.length()) {
      final String toInsert = curPath.toString();
      if (toInsert.isEmpty()) return;
      reverseInsert(root, toInsert, toInsert.length() - 1);
      return;
    }

    final char chr = source.charAt(i);
    final int len = curPath.length();
    insertAllSubsequence(source, curPath, i + 1);
    curPath.append(chr);
    insertAllSubsequence(source, curPath, i + 1);
    curPath.setLength(len);
  }

  private void reverseInsert(final Node root, final String word, final int i) {
    if (i == -1) {
      root.isWord = true;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    reverseInsert(root.next[chrIndex], word, i - 1);
  }

  private static final class Node {
    private boolean isWord;
    private final Node[] next = new Node[N];
  }
}
