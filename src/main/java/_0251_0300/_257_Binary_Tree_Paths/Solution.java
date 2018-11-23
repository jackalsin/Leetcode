package _0251_0300._257_Binary_Tree_Paths;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/26/2017.
 */
public class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) return result;
    dfs(result, root, new ArrayList<>() );
    return result;
  }

  private void dfs(List<String> result, TreeNode root, List<Integer> path) {
    if (root.left == null && root.right == null) {
      path.add(root.val);
      result.add(getResultPath(path));
      path.remove(path.size() - 1);
    } else {
      path.add(root.val);
      if (root.left != null) dfs(result, root.left, path);
      if (root.right != null) dfs(result, root.right, path);
      path.remove(path.size() - 1);
    }
  }

  private String getResultPath(final List<Integer> path) {
    StringBuilder sb = new StringBuilder();
    for(int i : path) {
      sb.append("->").append(i);
    }
    return sb.substring(2);
  }
}
