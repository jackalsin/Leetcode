package uber._341_Flatten_Nested_List_Iterator;

import definition.nestedInteger.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Directly flatten integer performance:
 *
 * <p>44 / 44 test cases passed. Status: Accepted Runtime: 9 ms
 *
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public final class NestedIterator implements Iterator<Integer> {
  private final Deque<NestedInteger> stack = new ArrayDeque<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i));
    }
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      final NestedInteger ni = stack.pop();
      if (ni.isInteger()) {
        stack.push(ni);
        return true;
      } else {
        final List<NestedInteger> niList = ni.getList();
        for (int i = niList.size() - 1; i >= 0; i--) {
          stack.push(niList.get(i));
        }
      }
    }

    return false;
  }

  @Override
  public Integer next() {
    assert hasNext();
    return stack.pop().getInteger();
  }
}
