package _0201_0250._212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/8/2017.
 */
public class Solution {
  private static final int N = 26;
  private static final char VISITED = '#';
  private int rows;
  private int cols;

  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    TrieNode root = buildTrie(words);
    rows = board.length;
    if (rows == 0) {
      return result;
    }
    cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        search(result, board, row, col, root);
      }
    }
    return result;
  }

  private void search(final List<String> result,
                      final char[][] board, int startRow, int startCol, final TrieNode parentNode) {
    if (startRow >= 0 && startCol >= 0 && startCol < cols && startRow < rows) {
      char chr = board[startRow][startCol];
      if (chr != VISITED && parentNode.next[chr - 'a'] != null) {
        TrieNode curNode = parentNode.next[chr - 'a'];
        if (curNode.word != null) {
          result.add(curNode.word);
          curNode.word = null;
        }
        board[startRow][startCol] = VISITED;
        search(result, board, startRow + 1, startCol, curNode);
        search(result, board, startRow, startCol + 1, curNode);
        search(result, board, startRow - 1, startCol, curNode);
        search(result, board, startRow, startCol - 1, curNode);
        board[startRow][startCol] = chr;
      }
    }
  }

  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode parent = root;
      for (char chr : word.toCharArray()) {
        int index = chr - 'a';
        if (parent.next[index] == null) {
          parent.next[index] = new TrieNode();
        }
        parent = parent.next[index];
      }
      parent.word = word;
    }

    return root;
  }

  private static final class TrieNode {
    String word;
    TrieNode[] next = new TrieNode[N];
    TrieNode() {}
  }
}
