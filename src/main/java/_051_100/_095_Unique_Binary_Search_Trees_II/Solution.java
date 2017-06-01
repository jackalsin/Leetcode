package _051_100._095_Unique_Binary_Search_Trees_II;

import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/1/2017.
 */
public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n <= 0) {
      return null;
    } else {
      return generateTrees(n);
    }
  }
}
