package _0651_0700._662_Maximum_Width_of_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/9/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int max = 0, last = 0;
    final Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(root, 0));
    while (!q.isEmpty()) {
      final int size = q.size();
      final int first = q.peek().index;
      for (int i = 0; i < size; ++i) {
        final Pair toRemove = q.remove();
        last = toRemove.index;
        final int index = toRemove.index;
        final TreeNode node = toRemove.node;
        if (node.left != null) {
          q.add(new Pair(node.left, 2 * index));
        }
        if (node.right != null) {
          q.add(new Pair(node.right, 2 * index + 1));
        }
      }
      max = Math.max(max, last - first + 1);
    }
    return max;
  }

  private static final class Pair {
    private final TreeNode node;
    private final int index;

    private Pair(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }
}
