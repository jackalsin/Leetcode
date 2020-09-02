package _0801_0850._820_Short_Encoding_of_Words;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 9/1/2020
 */
public final class SolutionI implements Solution {
  private final Node root = new Node();

  public int minimumLengthEncoding(String[] words) {
    int sum = 0;
    final int n = words.length;
    Arrays.sort(words, Comparator.comparingInt(String::length));
    for (int i = n - 1; i >= 0; --i) {
      final String word = words[i];
      final int cur = insert(root, word, word.length() - 1, false);
      if (cur != 0) {
        sum += cur + 1;
      }
    }
    return sum;
  }

  private int insert(final Node root, final String word, final int i, boolean isOnNewPath) {
    if (i == -1) {
      return isOnNewPath ? word.length() : 0;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
      isOnNewPath = true;
    }
    return insert(root.next[chrIndex], word, i - 1, isOnNewPath);
  }

  private static final class Node {
    private final Node[] next = new Node[26];
  }
}
