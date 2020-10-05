package _0301_0350._341_Flatten_Nested_List_Iterator;

import definition.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public final class NestedIteratorListIteratorSolution implements NestedIterator {

  private final Deque<ListIterator<NestedInteger>> stack;

  public NestedIteratorListIteratorSolution(List<NestedInteger> nestedList) {
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
