package linkedin._339_Nested_List_Weight_Sum;

import utils.nestedInteger.NestedInteger;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class SolutionIV implements Solution {
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private static int depthSum(final List<NestedInteger> nestedList, final int d) {
    int res = 0;
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        res += d * ni.getInteger();
      } else {
        res += depthSum(ni.getList(), d + 1);
      }
    }
    return res;
  }
}
