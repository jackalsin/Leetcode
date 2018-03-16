package interviews.uber._341_Flatten_Nested_List_Iterator;

import utils.nestedInteger.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Directly flatten integer performance:
 *
 * <p>44 / 44 test cases passed. Status: Accepted Runtime: 9 ms
 *
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public final class NestedIterator implements Iterator<Integer> {
  private final Stack<NestedInteger> stack = new Stack<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i));
    }
  }

  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      final NestedInteger resultNi = stack.peek();
      if (resultNi.isInteger()) {
        return true;
      }
      stack.pop();
      List<NestedInteger> list = resultNi.getList();
      for (int i = list.size() - 1; i >= 0; i--) {
        stack.add(list.get(i));
      }
    }
    return false;
  }
}
