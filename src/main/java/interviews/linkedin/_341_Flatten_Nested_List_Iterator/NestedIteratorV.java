package interviews.linkedin._341_Flatten_Nested_List_Iterator;

import utils.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class NestedIteratorV implements NestedIterator {
  private final Deque<NestedInteger> stack = new ArrayDeque<>();

  public NestedIteratorV(final List<NestedInteger> input) {
    if (input == null) return;
    for (int i = input.size() - 1; i >= 0; --i) {
      stack.push(input.get(i));
    }
  }

  public boolean hasNext() {
    while (!stack.isEmpty()) {
      final NestedInteger ni = stack.peek();
      if (ni.isInteger()) {
        return true;
      } else {
        stack.pop();
        final List<NestedInteger> toPush = ni.getList();
        for (int i = toPush.size() - 1; i >= 0; --i) {
          stack.push(toPush.get(i));
        }
      }
    }
    return false;
  }

  public Integer next() {
    final boolean exist = hasNext();
    assert exist;
    return stack.pop().getInteger();
  }
}
