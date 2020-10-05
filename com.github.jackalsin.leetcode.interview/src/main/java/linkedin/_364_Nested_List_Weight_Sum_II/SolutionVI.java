package linkedin._364_Nested_List_Weight_Sum_II;

import utils.nestedInteger.NestedInteger;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public int depthSumInverse(List<NestedInteger> nestedList) {
    final int depth = getDepth(nestedList);
    return depthSumInverse(nestedList, depth);
  }

  private static int depthSumInverse(List<NestedInteger> nestedList, int depth) {
    int res = 0;
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        res += depth * ni.getInteger();
      } else {
        res += depthSumInverse(ni.getList(), depth - 1);
      }
    }
    return res;
  }

  private static int getDepth(final List<NestedInteger> nestedList) {
    int depth = 1;
    for (NestedInteger ni : nestedList) {
      if (!ni.isInteger()) {
        depth = Math.max(depth, 1 + getDepth(ni.getList()));
      }
    }
    return depth;
  }
}
