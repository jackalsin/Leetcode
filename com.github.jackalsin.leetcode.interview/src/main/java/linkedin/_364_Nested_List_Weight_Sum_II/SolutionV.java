package linkedin._364_Nested_List_Weight_Sum_II;

import utils.nestedInteger.NestedInteger;

import java.util.List;

public final class SolutionV implements Solution {
  @Override
  public int depthSumInverse(List<NestedInteger> nestedList) {
    final int depth = getDepth(nestedList);

    return depthSum(nestedList, depth);
  }

  private static int depthSum(final List<NestedInteger> nestedList, final int depth) {
    int sum = 0;
    for (NestedInteger n : nestedList) {
      if (n.isInteger()) {
        sum += depth * n.getInteger();
      } else {
        sum += depthSum(n.getList(), depth - 1);
      }
    }
    return sum;
  }

  private static int getDepth(List<NestedInteger> nestedList) {
    int depth = 0;
    for (final NestedInteger n : nestedList) {
      if (n.isInteger()) {
        depth = Math.max(depth, 1);
      } else {
        depth = Math.max(depth, getDepth(n.getList()) + 1);
      }
    }
    return depth;
  }
}
