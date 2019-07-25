package interviews.linkedin._341_Flatten_Nested_List_Iterator;

import utils.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

public final class NestedIteratorIV implements NestedIterator {
  private final Deque<ListIterator<NestedInteger>> stack = new ArrayDeque<>();

  public NestedIteratorIV(List<NestedInteger> nestedList) {
    stack.push(nestedList.listIterator());
  }

  public boolean hasNext() {
    // always points to integer
    while (!stack.isEmpty()) {
      final ListIterator<NestedInteger> itr = stack.peek();
      if (itr.hasNext()) {
        final NestedInteger ni = itr.next();
        if (ni.isInteger()) {
          itr.previous();
          return true;
        } else {
          stack.push(ni.getList().listIterator());
        }
      } else {
        stack.pop();
      }
    }
    return false;
  }


  public Integer next() {
    final boolean res = hasNext();
    assert res;
    return stack.peek().next().getInteger();
  }

}
