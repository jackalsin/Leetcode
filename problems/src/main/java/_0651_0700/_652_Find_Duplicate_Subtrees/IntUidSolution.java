package _0651_0700._652_Find_Duplicate_Subtrees;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 12/24/2017.
 */
public final class IntUidSolution implements Solution {
  private static int nextId = 1;
  private static final String SEP = ",";
  private final Map<String, Integer> strToUid = new HashMap<>();
  private final Map<Integer, Integer> uidToCounts = new HashMap<>();
  private final List<TreeNode> result = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    serialize(root);
    return result;
  }

  private int serialize(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = serialize(root.left), right = serialize(root.right);
    StringBuilder sb = new StringBuilder().append(root.val).append(SEP).append(left)
        .append(SEP).append(right);
    String serializedResult = sb.toString();
    final int curId = strToUid.getOrDefault(serializedResult, nextId);
    if (curId == nextId) {
      nextId++;
    }
    uidToCounts.put(curId, uidToCounts.getOrDefault(curId, 0) + 1);
    if (strToUid.containsKey(serializedResult)) {
      if (uidToCounts.get(curId) == 2) {
        result.add(root);
      }
    } else {
      strToUid.put(serializedResult, curId);
    }
    return curId;
  }
}
