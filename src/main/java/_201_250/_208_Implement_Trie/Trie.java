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
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if (word == null || word.length() == 0) return;
    Node root = vals[word.charAt(0) - 'a'];
    if (root == null) {
      vals[word.charAt(0) - 'a'] = new Node(word.charAt(0));
      root = vals[word.charAt(0) - 'a'];
    }
    insert(word, 0, root);
  }

  private void insert(String word, int start, Node root) {
    char curChar = word.charAt(start);
    if (root.val == curChar) {
      if (start == word.length() - 1) {
        root.isEnd = true;
        return;
      }
      if (root.next == null) {
        root.next = new Node(word.charAt(start + 1));
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

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if (word == null || word.length() == 0) return false;
    Node root = vals[word.charAt(0) - 'a'];
    for (int i = 0; i < word.length(); ++i) {
      char chr = word.charAt(i);
      if (root == null) {
        return false;
      } else if (chr == root.val) {
        if (i == word.length() - 1) {
          return root.isEnd;
        } else {
          root = root.next;
        }
      } else if (chr < root.val) {
        root = root.left;
        i--;
      } else if (chr > root.val) {
        root = root.right;
        i--;
      } else {
        throw new IllegalStateException("You should not come here");
      }
    }
    return false;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    Node root = vals[prefix.charAt(0) - 'a'];
    for (int i = 0; i < prefix.length(); ++i) {
      char chr = prefix.charAt(i);
      if (root == null){
        return false;
      } else if (chr == root.val) {
        if (i == prefix.length() - 1) {
          return true;
        } else {
          root = root.next;
        }
      } else if (chr < root.val) {
        root = root.left;
        i--;
      } else if (chr > root.val) {
        root = root.right;
        i--;
      } else {
        throw new IllegalStateException("You should not come here");
      }
    }
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
