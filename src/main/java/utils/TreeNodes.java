package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public final class TreeNodes {
  private static final Set<Integer> VALID_LEN = new HashSet<>();
  static {
    for(int i = 0; i < 32; i++) {
      VALID_LEN.add((1 << i) - 1);
    }
  }

  private static TreeNode getTreeInorder(int[] vals) {
    return getTreeInorder(vals, 0, vals.length - 1);
  }

  private static TreeNode getTreeInorder(int[] vals, int start, int end) {
    int valsLen = (end - start) / 2 + start;
    if (VALID_LEN.contains(valsLen)) {
      if (valsLen == 1) {
        return new TreeNode(vals[start]);
      } else {
        int rootVal = vals[valsLen / 2]; //3 -> 1: 0, 1, 2;
        TreeNode root = new TreeNode(rootVal);
        root.left = getTreeInorder(vals, start, valsLen/2 - 1);
        root.right = getTreeInorder(vals, valsLen/2 + 1, end);
        return root;
      }
    } else {
      return null;
    }
  }


  private TreeNodes() {}

}
