package _0351_0400._364_Nested_List_Weight_Sum_II;

import utils.nestedInteger.NestedInteger;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/13/2017.
 */
public class Solution {
  /**
   * Given a nested list of integers, return the sum of all integers in the list weighted by their
   * depth. Each element is either an integer, or a list -- whose elements may also be integers or
   * other lists. Different from the previous question where weight is increasing from root to leaf,
   * now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the
   * root level integers have the largest weight. Example 1: Given the list [[1,1],2,[1,1]], return
   * 8. (four 1's at depth 1, one 2 at depth 2) Example 2: Given the list [1,[4,[6]]], return 17.
   * (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
   */
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int depth = getDepth(nestedList);
    return depthSumInverse(nestedList, depth);
  }

  private int depthSumInverse(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        sum += nestedInteger.getInteger() * depth;
      } else {
        sum += depthSumInverse(nestedInteger.getList(), depth - 1);
      }
    }
    return sum;
  }

  private int getDepth(List<NestedInteger> nestedList) {
    int depth = 0;
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        depth = Math.max(1, depth);
      } else {
        depth = Math.max(depth, getDepth(nestedInteger.getList()) + 1);
      }
    }
    return depth;
  }
}
