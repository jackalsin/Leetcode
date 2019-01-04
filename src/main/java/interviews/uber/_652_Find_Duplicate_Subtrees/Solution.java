package interviews.uber._652_Find_Duplicate_Subtrees;

import utils.TreeNode;

import java.util.*;

public final class Solution {
  private static final String SEP = ",";
  private final Set<TreeNode> result = new HashSet<>();
  private final Map<String, TreeNode> visited = new HashMap<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    serialize(root);
    return new ArrayList<>(result);
  }

  private String serialize(TreeNode root) {
    if (root == null) {
      return "null";
    }

    final String left = serialize(root.left),
        right = serialize(root.right);
    StringBuilder sb = new StringBuilder().append(root.val).append(SEP)
        .append(left).append(SEP).append(right);
    final String res = sb.toString();
    if (visited.containsKey(res)) {
      result.add(visited.get(res));
    } else {
      visited.put(res, root);
    }
    return res;
  }
}
