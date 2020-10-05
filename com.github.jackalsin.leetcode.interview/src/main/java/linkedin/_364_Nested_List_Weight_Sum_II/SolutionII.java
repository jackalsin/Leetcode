package linkedin._364_Nested_List_Weight_Sum_II;

import definition.nestedInteger.NestedInteger;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    final int depth = getDepth(nestedList);
    return depthSumInverse(nestedList, depth);
  }

  private static int depthSumInverse(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (final NestedInteger nestInt : nestedList) {
      if (nestInt.isInteger()) {
        sum += depth * nestInt.getInteger();
      } else {
        sum += depthSumInverse(nestInt.getList(), depth - 1);
      }
    }
    return sum;
  }

  private static int getDepth(List<NestedInteger> nestedList) {
    int depth = 1;
    for (final NestedInteger nestedInt : nestedList) {
      if (!nestedInt.isInteger()) {
        depth = Math.max(depth, getDepth(nestedInt.getList()) + 1);
      }
    }
    return depth;
  }

}
