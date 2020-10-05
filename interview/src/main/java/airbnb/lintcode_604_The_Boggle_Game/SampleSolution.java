package airbnb.lintcode_604_The_Boggle_Game;

import java.util.ArrayList;
import java.util.List;

public class SampleSolution {
  /*
   * @param board: a list of lists of character
   * @param words: a list of string
   * @return: an integer
   */
  private int n;
  private int m;
  private final int[] dirX = {0, 0, 1, -1};
  private final int[] dirY = {1, -1, 0, 0};
  private TrieNode root;
  private int max = 0;

  public int boggleGame(char[][] board, String[] words) {
    // write your code here
    if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
      return this.max;
    }
    this.n = board.length;
    this.m = board[0].length;
    this.root = new TrieNode();
    for (String word : words) {
      insert(word);
    }
    for (int i = 0; i < this.n; i++) {
      for (int j = 0; j < this.m; j++) {
        search(board, i, j, this.root, new ArrayList<String>(), new boolean[this.n][this.m]);
      }
    }
    return this.max;
  }

  private void search(char[][] board, int x, int y, TrieNode node, List<String> list, boolean[][] visited) {
    if (!inBound(x, y) || visited[x][y] || node.map[board[x][y] - 'a'] == null) {
      return;
    }
    node = node.map[board[x][y] - 'a'];
    visited[x][y] = true;
    if (node.word != null) {
      list.add(node.word);
      //每次加入新的word之后max可能会变化，需要check一下
      this.max = Math.max(this.max, list.size());
      //因为当前词已经加入进来了，所有要重新开始，从别的没有被marked的点开始找新的词
      for (int i = 0; i < this.n; i++) {
        for (int j = 0; j < this.m; j++) {
          search(board, i, j, this.root, list, visited);
        }
      }
      //回溯之前把当前词扔掉，回到上一步找别的方向继续
      list.remove(list.size() - 1);
      //这里是不用mark有点triky，拿example作为例子，如果abc有词了，那么所有以a或者ab为prefix的搜索都mark c为visited，因为别的词肯定比abc长，因为
      //绕过别的字母了，会造成总数更少，如果不mark的话会有超时的风险，比如有一个测试例是aaa aa的那个。
      //visited[x][y] = false;
      return;
    }
    for (int i = 0; i < 4; i++) {
      int next_x = x + this.dirX[i];
      int next_y = y + this.dirY[i];
      search(board, next_x, next_y, node, list, visited);
    }
    visited[x][y] = false;
  }

  private boolean inBound(int x, int y) {
    return x >= 0 && x < this.n && y >= 0 && y < this.m;
  }

  private void insert(String word) {
    TrieNode node = this.root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.map[c - 'a'] == null) {
        node.map[c - 'a'] = new TrieNode();
      }
      node = node.map[c - 'a'];
    }
    node.word = word;
  }

  private static final class TrieNode {
    TrieNode[] map;
    String word;

    TrieNode() {
      this.map = new TrieNode[26];
    }
  }


}
