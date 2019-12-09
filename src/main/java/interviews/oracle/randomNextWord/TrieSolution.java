package interviews.oracle.randomNextWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 12/8/2019
 */
public final class TrieSolution implements Solution {
  private static final int N = 26;
  private final Node root = new Node();
  private Node prevWord = null;
  private final Random rand = new Random();

  @Override
  public void addWord(String word) {
    addWord(root, word, 0);
  }

  private void addWord(final Node root, final String word, final int i) {
    if (i == word.length()) {
      if (prevWord != null) {
        prevWord.nextNodeList.add(root);
      }
      prevWord = root;
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    addWord(root.next[chrIndex], word, i + 1);
  }

  @Override
  public String getWord(String word) {
    return getWord(root, word, 0);
  }

  private String getWord(final Node root, final String word, final int i) {
    if (i == word.length()) {
      return getRandom(root.nextNodeList);
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      throw new IllegalArgumentException("Not present " + word);
    }
    return getWord(root.next[chrIndex], word, i + 1);
  }

  private String getRandom(final List<Node> nextNodeList) {
    final Node node = nextNodeList.get(rand.nextInt(nextNodeList.size()));
    return node.word;
  }

  private static final class Node {
    private String word;
    /**
     * next word
     */
    private final List<Node> nextNodeList = new ArrayList<>();
    private final Node[] next = new Node[N];
  }
}
