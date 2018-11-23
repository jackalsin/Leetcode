package _0301_0350._341_Flatten_Nested_List_Iterator;

import utils.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public final class NestedIteratorIntegerSolution implements NestedIterator {

  private final Deque<NestedInteger> stack = new ArrayDeque<>();

  public NestedIteratorIntegerSolution(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; --i) {
      stack.push(nestedList.get(i));
    }
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      final NestedInteger nestedInt = stack.peek();
      if (nestedInt.isInteger()) {
        return true;
      }
      stack.pop();
      final List<NestedInteger> list = nestedInt.getList();
      for (int i = list.size() - 1; i >= 0; --i) {
        stack.push(list.get(i));
      }
    }
    return false;
  }

  @Override
  public Integer next() {
    assert hasNext();
    return stack.pop().getInteger();
  }
}
