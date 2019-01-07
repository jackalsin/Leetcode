package interviews.uber._652_Find_Duplicate_Subtrees;

import utils.TreeNode;

import java.util.*;

public final class Solution {
  private static final String SEP = ",", NULL = "#";
  private final Map<String, TreeNode> strToNodes = new HashMap<>();
  private final Set<TreeNode> result = new HashSet<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    dfs(root);
    return new ArrayList<>(result);
  }

  private String dfs(TreeNode root) {
    if (root == null) {
      return NULL;
    }
    final String curStr =
        new StringBuilder().append(root.val).append(SEP).append(dfs(root.left))
            .append(SEP).append(dfs(root.right)).toString();
    TreeNode correspondingRoot = strToNodes.get(curStr);
    if (correspondingRoot == null) {
      strToNodes.put(curStr, root);
    } else {
      result.add(correspondingRoot);
    }
    return curStr;
  }
}
