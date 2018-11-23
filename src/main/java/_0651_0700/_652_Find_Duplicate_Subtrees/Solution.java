package _0651_0700._652_Find_Duplicate_Subtrees;

import utils.TreeNode;

import java.util.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 12/24/2017.
 */
public class Solution {
  private static final String SEP = ",";
  private final Map<String, TreeNode> allNodes = new HashMap<>();
  private final Set<TreeNode> result = new HashSet<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    serialize(root);
    return new ArrayList<>(result);
  }

  private String serialize(TreeNode root) {
    if (root == null) {
      return "null";
    }
    String left = serialize(root.left);
    String right = serialize(root.right);
    StringBuilder sb = new StringBuilder().append(root.val).append(SEP).append(left)
        .append(SEP).append(right);
    String serializedResult = sb.toString();
    System.out.println(serializedResult);
    if (allNodes.containsKey(serializedResult)) {
      result.add(allNodes.get(serializedResult));
    } else {
      allNodes.put(serializedResult, root);
    }
    return serializedResult;
  }
}
