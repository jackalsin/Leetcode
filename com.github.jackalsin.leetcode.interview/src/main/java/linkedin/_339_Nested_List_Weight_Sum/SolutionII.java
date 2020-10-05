package linkedin._339_Nested_List_Weight_Sum;

import utils.nestedInteger.NestedInteger;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private static int depthSum(final List<NestedInteger> nestedList, final int depth) {
    int sum = 0;
    for (final NestedInteger nestedInt : nestedList) {
      if (nestedInt.isInteger()) {
        sum += depth * nestedInt.getInteger();
      } else {
        sum += depthSum(nestedInt.getList(), depth + 1);
      }
    }
    return sum;
  }

}
