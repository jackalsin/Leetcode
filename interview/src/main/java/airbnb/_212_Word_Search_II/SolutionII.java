package airbnb._212_Word_Search_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/22/2021
 */
public final class SolutionII implements Solution {
  private static final char VISITED = '#';

  public List<String> findWords(char[][] board, String[] words) {
    if (board == null || board.length == 0) return Collections.emptyList();
    final int rows = board.length, cols = board[0].length;
    final TreeNode root = new TreeNode();
    for (final String word : words) {
      insert(root, word, 0);
    }
    final List<String> result = new ArrayList<>();
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        find(result, board, i, j, root);
      }
    }
    return result;
  }

  private static void find(final List<String> result, final char[][] board,
                           final int i, final int j, final TreeNode root) {
    if (root == null) return;
    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }
    final int rows = board.length, cols = board[0].length;
    if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == VISITED) return;
    final char chr = board[i][j];
    board[i][j] = VISITED;
    final int chrIndex = chr - 'a';
    find(result, board, i + 1, j, root.next[chrIndex]);
    find(result, board, i - 1, j, root.next[chrIndex]);
    find(result, board, i, j - 1, root.next[chrIndex]);
    find(result, board, i, j + 1, root.next[chrIndex]);
    board[i][j] = chr;
  }

  private static void insert(final TreeNode root, final String word, final int i) {
    if (word.length() == i) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new TreeNode();
    }
    insert(root.next[chrIndex], word, i + 1);
  }

  private static final class TreeNode {
    private final TreeNode[] next = new TreeNode[26];
    private String word;
  }
}
