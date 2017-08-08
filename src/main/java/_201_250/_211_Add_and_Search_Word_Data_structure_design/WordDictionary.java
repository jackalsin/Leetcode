package _201_250._211_Add_and_Search_Word_Data_structure_design;

/**
 * @author jacka
 * @version 1.0 on 8/8/2017.
 */
public final class WordDictionary {
  private static final int N = 26;
  private final Node[] nodes = new Node[N];
  /** Initialize your data structure here. */
  public WordDictionary() {

  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    int rootIndex = word.charAt(0) - 'a';
    if (nodes[rootIndex] == null) {
      nodes[rootIndex] = new Node(word.charAt(0));
    }
    addWord(word, 0, nodes[rootIndex]);
  }

  private void addWord(String word, int start, Node root) {

    for (int i = start; i < word.length(); ++i) {
      char chr = word.charAt(i);
      if (root == null) {
        throw new IllegalStateException("You should come here");
      } else if (root.val == chr) {
        if (i == word.length() - 1) {
          root.isEnd = true;
          return;
        } else {
          if (root.next == null) {
            root.next = new Node(word.charAt(i + 1));
          }
          root = root.next;
        }
      } else if (root.val > chr) {
        if (root.left == null) {
          root.left = new Node(chr);
        }
        root = root.left;
        i--;
      } else { // root.val < chr
        if (root.right == null) {
          root.right = new Node(chr);
        }
        root = root.right;
        i--;
      }
    }
  }
  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    if (word.charAt(0) == '.') {
      for (Node root : nodes) {
        if (search(word, 0, root)) {
          return true;
        }
      }
      return false;
    } else {
      int rootIndex = word.charAt(0) - 'a';
      return nodes[rootIndex] != null && search(word, 0, nodes[rootIndex]);
    }
  }

  private boolean search(String word, int start, Node root) {
    if (root == null) {
      return false;
    } else if (word.charAt(start) == '.') {
//      if (start == word.length() - 1) {
//        return search(word, start, root.left) || search(word, start, root.right) || root.isEnd;
//      } else {
//        return search(word, start, root.left)
//            || search(word, start, root.right)
//            || search(word, start + 1, root.next);
//      }
      return search(word, start, root.left) || search(word, start, root.right)
          || (start == word.length() - 1 ? root.isEnd :
          search(word, start + 1, root.next));
    } else if (word.charAt(start) == root.val) {
      if (start == word.length() - 1) {
        return root.isEnd;
      } else {
        return search(word, start + 1, root.next);
      }
    } else if (word.charAt(start) > root.val) {
      return search(word, start, root.right);
    } else {
      return search(word, start, root.left);
    }
  }


  private static final class Node {
    char val;
    Node left;
    Node right;
    Node next;
    boolean isEnd = false;
    Node(char val) {
      this.val = val;
    }
  }
}
