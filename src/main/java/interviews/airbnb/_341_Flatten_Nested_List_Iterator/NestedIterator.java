package interviews.airbnb._341_Flatten_Nested_List_Iterator;

import utils.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
public class NestedIterator implements Iterator<Integer> {
  private final Deque<NestedInteger> stack = new ArrayDeque<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i));
    }
  }

  @Override
  public Integer next() {
    hasNext();
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty() && !stack.peek().isInteger()) {
      final List<NestedInteger> list = stack.pop().getList();
      for (int i = list.size() - 1; i >= 0; i--) {
        stack.push(list.get(i));
      }
    }
    return !stack.isEmpty();
  }
}
