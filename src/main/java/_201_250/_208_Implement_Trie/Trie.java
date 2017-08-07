package _201_250._208_Implement_Trie;

/**
 * @author jacka
 * @version 1.0 on 8/7/2017.
 */
public final class Trie {
  private static final int N = 26;
  private final Node[] vals = new Node[N];
  /** Initialize your data structure here. */
  public Trie() {
    for (int i = 0; i < N; i++) {
      vals[i] = new Node((char) ('a' + i));
    }
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    Node root = vals[word.charAt(0)];
    insert(word, 0, root);
  }

  private void insert(String word, int start, Node root) {
    if(start ==  word.length()) {
      root.isEnd = true;
    } else {
      char curChar = word.charAt(start);
      if (root.val == curChar) {
        if (root.next == null) {
          root.next = new Node(curChar);
        }
        insert(word, start + 1, root.next);
      } else if (curChar < root.val) {
        if (root.left == null) {
          root.left = new Node(curChar);
        }
        insert(word, start, root.left);
      } else {
        if (root.right == null) {
          root.right = new Node(curChar);
        }
        insert(word, start, root.right);
      }
    }
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    return false;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return false;
  }

  private static final class Node {
    final char val;
    Node left;
    Node right;
    Node next;
    boolean isEnd = false;

    Node(char val) {
      this.val = val;
    }
  }
}
