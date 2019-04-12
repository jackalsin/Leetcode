package interviews.airbnb.lintcode_623_kEditDistance;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Revisit
 */
public final class SolutionI implements Solution {
  private final Node root = new Node();
  private final List<String> result = new ArrayList<>();

  public List<String> kDistance(String[] words, String target, int k) {
    if (words == null) {
      throw new NullPointerException();
    }

    for (String word : words) {
      insert(root, word, 0);
    }

    final int[] curDists = new int[target.length() + 1];
    for (int i = 0; i < curDists.length; i++) {
      curDists[i] = i;
    }
    search(root, target, curDists, k);
    return result;
  }

  private void search(final Node root, String target, final int[] prevDistance, final int k) {
    if (root == null || k < 0) {
      return;
    }
    if (root.word != null) {
      if (prevDistance[target.length()] <= k) {
        result.add(root.word);
      }
    }

    for (int i = 0; i < 26; i++) {
      if (root.next[i] == null) continue;
      final int[] curDistance = new int[target.length() + 1];
      curDistance[0] = prevDistance[0] + 1;
      for (int j = 0; j < target.length(); j++) {
        if (target.charAt(j) == i + 'a') {
          curDistance[j + 1] = prevDistance[j];
        } else {                    // replace            , add a char to target  , remove a char
          curDistance[j + 1] = min(prevDistance[j] + 1, curDistance[j] + 1, prevDistance[j + 1] + 1);
        }
      }
      search(root.next[i], target, curDistance, k);
    }
  }

  private static int min(final int a, final int... b) {
    int res = a;
    for (int c : b) {
      res = Math.min(c, res);
    }
    return res;
  }


  private void insert(Node root, String word, int i) {
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
    private final Node[] next = new Node[26];
    private String word = null;
  }
}
