package _1001_1050._1028_Recover_a_Tree_From_Preorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 7/28/2019
 */
public final class RecursiveSolution implements Solution {
  @Override
  public TreeNode recoverFromPreorder(String s) {
    final Deque<Pair> q = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      int depth = 0;
      // calculate depth
      while (s.charAt(i) == '-') {
        depth++;
        i++;
      }
      // get the num
      int num = s.charAt(i) - '0';
      while (i + 1 < s.length() && s.charAt(i + 1) != '-') {
        num = num * 10 + s.charAt(i + 1) - '0';
        i++;
      }
      final Pair p = new Pair(num, depth);
      q.add(p);
    }
    return recoverFromPreorder(q, 0);
  }

  private static TreeNode recoverFromPreorder(final Deque<Pair> q, final int depth) {
    final Pair p = q.remove();
    final TreeNode root = new TreeNode(p.str);
    if (!q.isEmpty() && q.peek().depth == depth + 1) {
      root.left = recoverFromPreorder(q, depth + 1);
    }
    if (!q.isEmpty() && q.peek().depth == depth + 1) {
      root.right = recoverFromPreorder(q, depth + 1);
    }
    return root;
  }

  private static final class Pair {
    private final int str, depth;

    private Pair(int str, int depth) {
      this.str = str;
      this.depth = depth;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "str=" + str +
          ", depth=" + depth +
          '}';
    }
  }
}
