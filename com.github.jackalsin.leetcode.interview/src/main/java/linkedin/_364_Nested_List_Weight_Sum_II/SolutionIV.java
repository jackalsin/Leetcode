package linkedin._364_Nested_List_Weight_Sum_II;

import definition.nestedInteger.NestedInteger;

import java.util.List;

public final class SolutionIV implements Solution {
  @Override
  public int depthSumInverse(List<NestedInteger> nestedList) {
    final int depth = getDepth(nestedList);
    return depthSum(nestedList, depth);
  }

  private static int getDepth(final List<NestedInteger> nestedList) {
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

  private static int depthSum(final List<NestedInteger> nestedList, final int depth) {
    int sum = 0;

    for (final NestedInteger n : nestedList) {
      if (n.isInteger()) {
        sum += depth * n.getInteger();
      } else {
        sum += depthSum(n.getList(), depth - 1);
      }
    }

    return sum;
  }
}
