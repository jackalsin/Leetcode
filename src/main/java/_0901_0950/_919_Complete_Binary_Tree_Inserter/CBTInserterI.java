package _0901_0950._919_Complete_Binary_Tree_Inserter;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class CBTInserterI implements CBTInserter {
  private final TreeNode root;
  private List<TreeNode> lastLevel = new ArrayList<>(),
      prevLastLevel = new ArrayList<>();

  public CBTInserterI(TreeNode root) {
    /*
      The initial given tree is complete and contains between 1 and 1000 nodes.
      CBTInserter.insert is called at most 10000 times per test case.
      Every value of a given or inserted node is between 0 and 5000.
    */
    this.root = root;
    final Queue<TreeNode> q = new ArrayDeque<>() {{
      add(root);
    }};
    lastLevel.addAll(q);
    for (int expectedSize = 1; q.size() == expectedSize; expectedSize *= 2) {
      final int size = q.size();
      prevLastLevel = lastLevel;
      lastLevel = new ArrayList<>();
      for (int i = 0; i < size; ++i) {
        final TreeNode toRemove = q.remove();
        if (toRemove.left != null) {
          lastLevel.add(toRemove.left);
          q.add(toRemove.left);
        }
        if (toRemove.right != null) {
          lastLevel.add(toRemove.right);
          q.add(toRemove.right);
        }
      } // end of for size;
    } // end of while
  }

  public int insert(int v) {
    final TreeNode toAdd = new TreeNode(v);
    // 0 -> 0, 1 -> 0
//    System.out.println(lastLevel + ", " + prevLastLevel);
    final int lastLevelSize = lastLevel.size();
    final TreeNode parent = prevLastLevel.get(lastLevelSize / 2);
    if (parent.left == null) {
      parent.left = toAdd;
    } else {
      parent.right = toAdd;
    }
    lastLevel.add(toAdd);
    if (lastLevel.size() == 2 * prevLastLevel.size()) {
      prevLastLevel = lastLevel;
      lastLevel = new ArrayList<>();
    }
    return parent.val;
  }

  public TreeNode get_root() {
    return root;
  }
}
