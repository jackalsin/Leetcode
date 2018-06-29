package interviews.linkedin._364_Nested_List_Weight_Sum_II;

import utils.nestedInteger.NestedInteger;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int depth = getDepth(nestedList);
    return depthSumInverse(nestedList, depth);
  }

  private int depthSumInverse(List<NestedInteger> nestedList, int depth) {
    int result = 0;
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        result += nestedInteger.getInteger() * depth;
      } else {
        result += depthSumInverse(nestedInteger.getList(), depth - 1);
      }
    }
    return result;
  }

  private int getDepth(List<NestedInteger> nestedList) {
    int depth = 1;
    for (NestedInteger nestedInteger : nestedList) {
      if (!nestedInteger.isInteger()) {
        depth = Math.max(depth, getDepth(nestedInteger.getList()) + 1);
      }
    }
    return depth;
  }
}
