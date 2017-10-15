package _351_400._366_Find_Leaves_of_Binary_Tree;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/13/2017.
 */
public class Solution {

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    getHeight(root, result);
    return result;
  }

  private int getHeight(TreeNode root, List<List<Integer>> result) {
    if (root == null) {
      return -1;
    }

    int left = getHeight(root.left, result);
    int right = getHeight(root.right, result);
    int curr = Math.max(left, right) + 1;

    // if the current level has not been reached, we create a new list;
    if (result.size() <= curr) {
      result.add(new ArrayList<>());
    }
    result.get(curr).add(root.val);
    return curr;
  }
}

