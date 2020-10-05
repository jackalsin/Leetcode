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
public final class NestedIteratorI implements NestedIterator {

  private final Deque<ListIterator<NestedInteger>> stack = new ArrayDeque<>();

  public NestedIteratorI(List<NestedInteger> nestedList) {
    stack.push(nestedList.listIterator());
  }

  @Override
  public boolean hasNext() {
    // always point to the integer.
    while (!stack.isEmpty()) {
      if (stack.peek().hasNext()) {
        final NestedInteger nestedInteger = stack.peek().next();
        if (nestedInteger.isInteger()) {
          stack.peek().previous(); // go back
          return true;
        }
        stack.push(nestedInteger.getList().listIterator());
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
