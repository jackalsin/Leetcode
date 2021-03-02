package apple._341_Flatten_Nested_List_Iterator;

import definition.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/1/2021
 */
public final class NestedIteratorII implements NestedIterator {
  private final Deque<NestedInteger> stack = new ArrayDeque<>();

  public NestedIteratorII(List<NestedInteger> nestedList) {
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
      if (stack.peek().isInteger()) {
        return true;
      }
      final NestedInteger toRemove = stack.pop();
      final List<NestedInteger> list = toRemove.getList();
      for (int i = list.size() - 1; i >= 0; --i) {
        stack.push(list.get(i));
      }
    }
    return false;
  }
}
