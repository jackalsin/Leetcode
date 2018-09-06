package interviews.linkedin._341_Flatten_Nested_List_Iterator;

import utils.nestedInteger.NestedInteger;

import java.util.*;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public final class NestedIterator implements Iterator<Integer> { // TODO: Revisit

  private final Deque<ListIterator<NestedInteger>> stack = new ArrayDeque<>();

  public NestedIterator(List<NestedInteger> nestedList) {
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
