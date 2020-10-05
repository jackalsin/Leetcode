package linkedin.mianjing._364_Nested_List_Weight_Sum_II;

import definition.nestedInteger.NestedInteger;

import java.util.List;

public class Solution {

  public int depthSumInverse(List<NestedInteger> nestedList) {
    final int depth = getDepth(nestedList);
    return depthSum(nestedList, depth);
  }

  private static int depthSum(final List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger nestInt : nestedList) {
      if (nestInt.isInteger()) {
        sum += depth * nestInt.getInteger();
      } else {
        sum += depthSum(nestInt.getList(), depth - 1);
      }
    }
    return sum;
  }

  private static int getDepth(final List<NestedInteger> nestedList) {
    int depth = 0;
    for (NestedInteger nestInt : nestedList) {
      if (nestInt.isInteger()) {
        depth = Math.max(1, depth);
      } else {
        depth = Math.max(depth, getDepth(nestInt.getList()) + 1);
      }
    }
    return depth;
  }
}
