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
public final class NestedIteratorIII implements NestedIterator {
  private final Deque<ListIterator<NestedInteger>> stack = new ArrayDeque<>();

  public NestedIteratorIII(List<NestedInteger> nestedList) {
    stack.push(nestedList.listIterator());
  }

  public boolean hasNext() {
    while (!stack.isEmpty()) {
      final ListIterator<NestedInteger> itr = stack.peek();
      if (itr.hasNext()) {
        final NestedInteger nestedInteger = itr.next();
        if (nestedInteger.isInteger()) {
          itr.previous();
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

  public Integer next() {
    hasNext();
    return stack.peek().next().getInteger();
  }
}
