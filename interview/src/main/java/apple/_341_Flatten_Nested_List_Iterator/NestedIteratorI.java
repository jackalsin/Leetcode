package apple._341_Flatten_Nested_List_Iterator;

import definition.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/13/2021
 */
public final class NestedIteratorI implements NestedIterator {
  private final Deque<NestedInteger> stack = new ArrayDeque<>();

  public NestedIteratorI(List<NestedInteger> nestedList) {
    final int n = nestedList.size();
    for (int i = n - 1; i >= 0; --i) {
      stack.push(nestedList.get(i));
    }
  }

  public Integer next() {
    final boolean hasNext = hasNext();
    assert hasNext && !stack.isEmpty() && stack.peek().isInteger();
    return stack.pop().getInteger();
  }

  public boolean hasNext() {
    while (!stack.isEmpty()) {
      final NestedInteger cur = stack.peek();
      if (cur.isInteger()) {
        return true;
      } else {
        final List<NestedInteger> curList = stack.pop().getList();
        for (int i = curList.size() - 1; i >= 0; --i) {
          stack.push(curList.get(i));
        }
      }
    }
    return false;
  }
}
