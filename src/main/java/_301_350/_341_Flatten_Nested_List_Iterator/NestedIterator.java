package _301_350._341_Flatten_Nested_List_Iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import utils.nestedInteger.NestedInteger;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public final class NestedIterator implements Iterator<Integer> {

  private final Deque<ListIterator<NestedInteger>> stack;

  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new ArrayDeque<>();
    stack.addFirst(nestedList.listIterator());
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      if (!stack.peekLast().hasNext()) {
        stack.removeLast();
      } else {
        NestedInteger nestedInteger = stack.peekLast().next();
        if (nestedInteger.isInteger()) {
          stack.peekLast().previous();
          return true;
        }
        stack.addLast(nestedInteger.getList().listIterator());
      }
    }
    return false;
  }

  @Override
  public Integer next() {
    hasNext();
    return stack.peekLast().next().getInteger();
  }
}
