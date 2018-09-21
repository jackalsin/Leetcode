package interviews.linkedin._339_Nested_List_Weight_Sum;

import utils.nestedInteger.NestedInteger;

import java.util.List;

public class SolutionIII implements Solution {
  @Override
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private int depthSum(final List<NestedInteger> nestedList, final int depth) {
    int sum = 0;
    for (final NestedInteger i : nestedList) {
      if (i.isInteger()) {
        sum += depth * i.getInteger();
      } else {
        sum += depthSum(i.getList(), depth + 1);
      }
    }
    return sum;
  }
}
