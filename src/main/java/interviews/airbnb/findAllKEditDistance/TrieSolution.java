package interviews.airbnb.findAllKEditDistance;

import java.util.ArrayList;
import java.util.List;

public final class TrieSolution implements Solution {
  private final Node root = new Node();
  private static final List<Character> PATH = new ArrayList<>();

  public List<String> getKEditDistance(String[] words, String target, int k) {
    final List<String> result = new ArrayList<>();
    if (words == null) {
      return result;
    }
    for (String str : words) {
      insert(root, str, 0);
    }

    dfs(result, root, target, 0, k);
    return result;
  }

  private static void dfs(final List<String> result, final Node root, final String target, final int i, final int k) {
    System.out.println(PATH);
    if (k < 0) {
      return;
    } else if (k == 0) {
      if (root != null && root.word != null) {
        result.add(root.word);
      }
    }
    if (i < target.length()) { // replace
      final char chr = target.charAt(i);
      PATH.add('c');
      for (int c = 'a'; c <= 'z'; c++) {
        PATH.set(PATH.size() - 1, (char) c);
        dfs(result, root == null ? root : root.next[c - 'a'], target, i + 1,
            k - (root != null && chr == c ? 0 : 1));
      }
      PATH.remove(PATH.size() - 1);
    }

    {
      // add: target.charAt(i)算是加上去的
      dfs(result, root, target, i + 1, k - 1);
    }

    {
      // remove todo: bug
      for (int c = 'a'; c <= 'z'; c++) {
        dfs(result, root == null ? root : root.next[c - 'a'], target, i, k - 1);
      }
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
