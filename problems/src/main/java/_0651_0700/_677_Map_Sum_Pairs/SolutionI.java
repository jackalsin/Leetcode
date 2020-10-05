package _0651_0700._677_Map_Sum_Pairs;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public final class SolutionI implements MapSum {

  private final Node root = new Node(null);

  public void insert(String key, int val) {
    insert(root, key, val, 0);
  }

  private void insert(final Node root, final String word, int val, int i) {
    final int prev = root.val;
    root.val += val;
    if (i == word.length()) {
      if (root.isWord) {
        update(root, prev);
      }
      root.isWord = true;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node(root);
    }
    insert(root.next[chrIndex], word, val, i + 1);
  }

  private void update(final Node root, final int val) {
    if (root == null) {
      return;
    }
    root.val -= val;
    update(root.parent, val);
  }

  public int sum(String prefix) {
    return sum(root, prefix, 0);
  }

  private int sum(final Node root, final String prefix, final int i) {
    if (i == prefix.length()) {
      return root.val;
    }

    final char chr = prefix.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return 0;
    }
    return sum(root.next[chrIndex], prefix, i + 1);
  }

  private static final class Node {
    private boolean isWord;
    private final Node parent;
    private final Node[] next = new Node[26];
    private int val;

    private Node(Node parent) {
      this.parent = parent;
    }
  }
}
