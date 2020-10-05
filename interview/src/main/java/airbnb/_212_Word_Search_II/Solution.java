package airbnb._212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public class Solution {
  private static final char VISITED = '#';

  public List<String> findWords(char[][] board, String[] words) {
    final List<String> result = new ArrayList<>();
    if (board == null || board.length == 0) {
      return result;
    }
    final int rows = board.length, cols = board[0].length;
    final TrieNode root = new TrieNode();
    for (String word : words) {
      insert(root, word, 0);
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        dfs(result, board, rows, cols, row, col, root);
      }
    }

    return result;
  }

  private static void dfs(final List<String> result, char[][] board, final int rows, final int cols, int row, int col, TrieNode root) {
    if (root == null) {
      return;
    }

    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }

    if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] == VISITED) {
      return;
    }
    final char chr = board[row][col];
    final int chrIndex = chr - 'a';
    board[row][col] = VISITED;
    dfs(result, board, rows, cols, row + 1, col, root.next[chrIndex]);
    dfs(result, board, rows, cols, row - 1, col, root.next[chrIndex]);
    dfs(result, board, rows, cols, row, col + 1, root.next[chrIndex]);
    dfs(result, board, rows, cols, row, col - 1, root.next[chrIndex]);
    board[row][col] = chr;
  }

  private static void insert(final TrieNode root, String word, int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int charIndex = chr - 'a';
    if (root.next[charIndex] == null) {
      root.next[charIndex] = new TrieNode();
    }
    insert(root.next[charIndex], word, i + 1);
  }

  private static final class TrieNode {
    private String word;
    private final TrieNode[] next = new TrieNode[26];
  }
}
