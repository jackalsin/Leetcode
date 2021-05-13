package google.leafSum;

/**
 * @author jacka
 * @version 1.0 on 5/12/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int leafOfSum(Node root) {
    if (root == null) return 0;
    int sum = 0;
    while (root != null) {
      if (root.children.isEmpty()) {
        sum += root.val;
        root = root.parent;
        continue;
      }
      if (root.itr == null) root.itr = root.children.iterator();
      if (root.itr.hasNext()) {
        root = root.itr.next();
      } else {
        root = root.parent;
      }
    }
    return sum;
  }
}
