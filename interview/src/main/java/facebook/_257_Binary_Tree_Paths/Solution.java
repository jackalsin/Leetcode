package facebook._257_Binary_Tree_Paths;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();

    binaryTreePaths(result, new ArrayList<>(), root);
//    System.out.println(result);
    return normalize(result);
  }

  private List<String> normalize(List<List<Integer>> input) {
    final List<String> result = new ArrayList<>();
    for (List<Integer> curLine : input) {
      final StringBuilder sb = new StringBuilder();
      sb.append(curLine.get(0));
      for (int i = 1; i < curLine.size(); i++) {
        sb.append("->").append(curLine.get(i));
      }
      result.add(sb.toString());
    }
    return result;
  }

  private void binaryTreePaths(final List<List<Integer>> result, final List<Integer> curPath, final TreeNode root) {
    if (root == null) {
      return;
    }
    curPath.add(root.val);
    if (root.left == null && root.right == null) {
      result.add(new ArrayList<>(curPath));
      curPath.remove(curPath.size() - 1);
      return;
    }
    if (root.left != null) {
      binaryTreePaths(result, curPath, root.left);
    }

    if (root.right != null) {
      binaryTreePaths(result, curPath, root.right);
    }
    curPath.remove(curPath.size() - 1);
  }
}
