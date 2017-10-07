package _301_350._339_Nested_List_Weight_Sum;

import java.util.List;

import utils.nestedInteger.NestedInteger;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 *
 * // This is the interface that allows for creating nested lists. // You should not implement it,
 * or speculate about its implementation public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a nested list. public
 * boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a single integer //
 * Return null if this NestedInteger holds a nested list public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a nested list // Return
 * null if this NestedInteger holds a single integer public List<NestedInteger> getList(); }
 */
public class Solution {

  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private int depthSum(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger nestedInteger : nestedList) {
      sum += nestedInteger.isInteger() ? nestedInteger.getInteger() * depth :
          depthSum(nestedInteger.getList(), depth + 1);
    }
    return sum;
  }
}
