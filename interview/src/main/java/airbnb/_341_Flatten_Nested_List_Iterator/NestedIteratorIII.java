package airbnb._341_Flatten_Nested_List_Iterator;

import definition.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/30/2021
 */
public final class NestedIteratorIII implements NestedIterator {
  private final Deque<NestedInteger> stack = new ArrayDeque<>();

  public NestedIteratorIII(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; --i) {
      stack.push(nestedList.get(i));
    }
  }

  public Integer next() {
    final boolean exist = hasNext();
    assert exist;
    final NestedInteger toRemove = stack.pop();
    return toRemove.getInteger();
  }

  public boolean hasNext() {
    while (!stack.isEmpty()) {
      if (stack.peek().isInteger()) return true;
      final List<NestedInteger> list = stack.pop().getList();
      for (int i = list.size() - 1; i >= 0; --i) {
        stack.push(list.get(i));
      }
    }
    return false;
  }
}
