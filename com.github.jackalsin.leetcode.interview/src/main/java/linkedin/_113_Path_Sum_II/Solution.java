package linkedin._113_Path_Sum_II;

import utils.binaryTree.TreeNode;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
public interface Solution {
  /**
   * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
   *
   * @param root
   * @param sum
   * @return
   */
  List<List<Integer>> pathSum(TreeNode root, int sum);
}
