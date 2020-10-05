package airbnb._341_Flatten_Nested_List_Iterator;

import definition.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * This solution is align with the requirement of this one
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=518090&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D37%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 * The main requirement is not to use any iterator
 *
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
public final class NestedIteratorII implements NestedIterator {
  private final Deque<NestedInteger> stack = new ArrayDeque<>();

  public NestedIteratorII(List<NestedInteger> nestedList) {
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
      final NestedInteger toRemove = stack.pop();
      final List<NestedInteger> l = toRemove.getList();
      for (int i = l.size() - 1; i >= 0; i--) {
        stack.push(l.get(i));
      }
    }
    return !stack.isEmpty();
  }
}
