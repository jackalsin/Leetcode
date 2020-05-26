package _0051_0100._095_Unique_Binary_Search_Trees_II;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jacka
 * @version 1.0 on 6/1/2017.
 */
public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n <= 0) return new ArrayList<>();
    return generateTrees(1, n);
  }

  /**
   * T(n) = 2*(T(n-1) + T(n-2) + ... + T(1) + T(0)), T(n) should equal to $O(2^n)$
   * Time complexity will be exponential
   *
   * @param start start value (inclusive)
   * @param end   end value (inclusive)
   * @return
   */
  private List<TreeNode> generateTrees(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }
    if (start == end) {
      result.add(new TreeNode(start));
      return result;
    }
    List<TreeNode> left, right;
    for (int i = start; i <= end; i++) {
      left = generateTrees(start, i - 1);
      right = generateTrees(i + 1, end);
      for (TreeNode leftChild : left) {
        for (TreeNode rightChild : right) {
          TreeNode curRoot = new TreeNode(i);
          curRoot.left = leftChild;
          curRoot.right = rightChild;
          result.add(curRoot);
        }
      }
    }
    return result;
  }
}
