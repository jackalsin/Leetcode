package linkedin._341_Flatten_Nested_List_Iterator;

import definition.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public final class NestedIteratorII implements NestedIterator {
  private Deque<ListIterator<NestedInteger>> stack = new ArrayDeque<>();

  public NestedIteratorII(List<NestedInteger> nestedList) {
    stack.push(nestedList.listIterator());
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      if (stack.peek().hasNext()) {
        final NestedInteger nestedInteger = stack.peek().next();
        if (nestedInteger.isInteger()) {
          stack.peek().previous();
          return true;
        } else {
          stack.push(nestedInteger.getList().listIterator());
        }
      } else {
        stack.pop();
      }
    }
    return false;
  }

  @Override
  public Integer next() {
    hasNext();
    return stack.peek().next().getInteger();
  }
}
