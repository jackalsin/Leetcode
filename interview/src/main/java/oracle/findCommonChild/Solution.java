package oracle.findCommonChild;

import definition.binaryTree.TreeNode;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public interface Solution {
  /**
   * Input: (A, X), return C or B
   * <p>
   * Follow up 是return most RECENT common descent
   *
   * @param rootA
   * @param rootB
   * @return
   */
  List<Integer> getCommonChild(final TreeNode rootA, final TreeNode rootB);

  int getMostRecentCommonChild(final TreeNode rootA, final TreeNode rootB);
}
