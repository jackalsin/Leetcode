package interviews.linkedin._1028_Recover_a_Tree_From_Preorder_Traversal;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public final class SolutionI implements Solution {
  @Override
  public TreeNode recoverFromPreorder(String S) {
    if (S == null) return null;
    final Queue<Node> q = new ArrayDeque<>();
    final char[] chars = S.toCharArray();

    for (int i = 0; i < chars.length; ++i) {
      int depth = 0;
      while (i < chars.length && chars[i] == '-') {
        depth++;
        ++i;
      }
      int val = chars[i] - '0';
      while (i + 1 < chars.length && chars[i + 1] != '-') {
        val = val * 10 + (chars[i + 1] - '0');
        ++i;
      }
      q.add(new Node(depth, val));
    }
    return recoverFromPreorder(q, 0);
  }

  private static TreeNode recoverFromPreorder(final Queue<Node> q, final int depth) {
    if (q.isEmpty() || q.peek().depth != depth) {
      return null;
    }
    final Node rootNode = q.remove();
    final TreeNode root = new TreeNode(rootNode.val);
    root.left = recoverFromPreorder(q, depth + 1);
    root.right = recoverFromPreorder(q, depth + 1);
    return root;
  }

  private static final class Node {
    private final int depth, val;

    private Node(int depth, int val) {
      this.depth = depth;
      this.val = val;
    }
  }
}
