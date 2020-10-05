package linkedin._364_Nested_List_Weight_Sum_II;

import definition.nestedInteger.NestedInteger;

import java.util.List;

public final class SolutionIII implements Solution {
  @Override
  public int depthSumInverse(List<NestedInteger> nestedList) {
    final int depth = getDepth(nestedList);
    return depthSum(nestedList, depth);
  }

  private static int depthSum(final List<NestedInteger> nestedList, final int depth) {
    int sum = 0;
    for (final NestedInteger i : nestedList) {
      if (i.isInteger()) {
        sum += depth * i.getInteger();
      } else {
        sum += depthSum(i.getList(), depth - 1);
      }
    }
    return sum;
  }

  private static int getDepth(final List<NestedInteger> nestedList) {
    int depth = 0;
    for (final NestedInteger i : nestedList) {
      if (i.isInteger()) {
        depth = Math.max(depth, 1);
      } else {
        depth = Math.max(depth, getDepth(i.getList()) + 1);
      }
    }
    return depth;
  }
}
