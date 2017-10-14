package _351_400._366_Find_Leaves_of_Binary_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import utils.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/13/2017.
 */
public class Solution {

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    Map<TreeNode, Integer> childrenCounts = new HashMap<>();
    getParents(root, parents, childrenCounts);
    while (!childrenCounts.isEmpty()) {
      List<TreeNode> leafNodes = new ArrayList<>();
      for (Map.Entry<TreeNode, Integer> entry: childrenCounts.entrySet()) {
        if (entry.getValue() == 0) {
          leafNodes.add(entry.getKey());
        }
      }

      List<Integer> curResult = new ArrayList<>();
      for (TreeNode cur : leafNodes) {
        curResult.add(cur.val);
        childrenCounts.remove(cur);
        final TreeNode parent = parents.get(cur);
        if (parent != null) {
          childrenCounts.put(parent, childrenCounts.get(parent) - 1);
        }
      }
      result.add(curResult);
    }
    return result;
  }

  private void  getParents(TreeNode root, Map<TreeNode, TreeNode> parents,
                           Map<TreeNode, Integer> childrenCounts) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode parent = queue.remove();
      childrenCounts.put(parent, 0);
      if (parent.left != null) {
        queue.add(parent.left);
        parents.put(parent.left, parent);
        childrenCounts.put(parent, childrenCounts.get(parent) + 1);
      }
      if (parent.right != null) {
        queue.add(parent.right);
        parents.put(parent.right, parent);
        childrenCounts.put(parent, childrenCounts.get(parent) + 1);
      }
    }
  }
}

