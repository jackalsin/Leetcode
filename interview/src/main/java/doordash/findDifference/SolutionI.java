package doordash.findDifference;

import java.util.Map;
import java.util.stream.Collectors;

public final class SolutionI implements Solution {
  @Override
  public int findDiff(final Node root1, final Node root2) {
    if (root1 == null && root2 == null) return 0;
    if (root1 == null) return getNodes(root2);
    if (root2 == null) return getNodes(root1);
    if (!root1.key.equals(root2.key) || root1.val != root2.val) {
      return getNodes(root1) + getNodes(root2);
    }
    int res = 0;
    final Map<String, Node> rightChildren = root2.children.stream().
        collect(Collectors.toMap(n -> n.key, n -> n));
    for (final Node c : root1.children) {
      if (rightChildren.containsKey(c.key)) {
        res += findDiff(c, rightChildren.remove(c.key));
      } else {
        res += getNodes(c);
      }
    }
    for (final var e : rightChildren.entrySet()) {
      final Node node = e.getValue();
      res += getNodes(node);
    }
    return res;
  }

  private int getNodes(final Node root) {
    if (root == null) return 0;
    int res = 1;
    for (final Node c : root.children) {
      res += getNodes(c);
    }
    return res;
  }
}
