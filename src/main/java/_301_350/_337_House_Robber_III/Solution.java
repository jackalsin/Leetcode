package _301_350._337_House_Robber_III;

import java.util.HashMap;
import java.util.Map;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/4/2017.
 */
public class Solution {
  private Map<TreeNode, int[]> nodesToMaxRobTrueFalse;

  public int rob(TreeNode root) {
    nodesToMaxRobTrueFalse = new HashMap<>();
    return rob(root, true);
  }

  private int rob(TreeNode root, boolean canAdd) {
    if (root == null) {
      return 0;
    } else if (nodesToMaxRobTrueFalse.containsKey(root)) {
      int[] trueFalse = nodesToMaxRobTrueFalse.get(root);
      return canAdd ? Math.max(trueFalse[0], trueFalse[1]) : trueFalse[1];
    } else {
      int leftAdd = rob(root.left, true);
      int leftNotAdd = rob(root.left, false);
      int rightAdd = rob(root.right, true);
      int rightNotAdd = rob(root.right, false);
      int addRootMax = leftNotAdd + root.val + rightNotAdd;
      int notAddRootMax = 0;
      notAddRootMax = Math.max(notAddRootMax, leftNotAdd + rightAdd);
      notAddRootMax = Math.max(notAddRootMax, leftAdd + rightNotAdd);
      notAddRootMax = Math.max(notAddRootMax, leftAdd + rightAdd);
      nodesToMaxRobTrueFalse.put(root, new int[] {addRootMax, notAddRootMax});
      return canAdd ? Math.max(notAddRootMax, addRootMax) : notAddRootMax;
    }
  }
}
