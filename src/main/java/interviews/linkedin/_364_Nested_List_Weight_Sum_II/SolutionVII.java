package interviews.linkedin._364_Nested_List_Weight_Sum_II;

import utils.nestedInteger.NestedInteger;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/4/2019
 */
public final class SolutionVII implements Solution {
  @Override
  public int depthSumInverse(List<NestedInteger> nestedList) {
    final int depth = getDepth(nestedList);
    return depthSumInverse(nestedList, depth);
  }

  private static int depthSumInverse(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        sum += depth * ni.getInteger();
      } else {
        sum += depthSumInverse(ni.getList(), depth - 1);
      }
    }
    return sum;
  }

  private static int getDepth(List<NestedInteger> nestedList) {
    int depth = 0;
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        depth = Math.max(depth, 1);
      } else {
        depth = Math.max(depth, getDepth(ni.getList()) + 1);
      }
    }
    return depth;
  }
}
