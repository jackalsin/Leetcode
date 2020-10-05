package linkedin._339_Nested_List_Weight_Sum;

import definition.nestedInteger.NestedInteger;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class SolutionV implements Solution {
  @Override
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private static int depthSum(final List<NestedInteger> nestedList, final int depth) {
    int sum = 0;
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        sum += depth * ni.getInteger();
      } else {
        sum += depthSum(ni.getList(), depth + 1);
      }
    }
    return sum;
  }
}
