package interviews.uber._341_Flatten_Nested_List_Iterator;

import utils.nestedInteger.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public final class NestedIterator implements Iterator<Integer> {
  private int i = 0;
  private final List<Integer> list = new ArrayList<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    for (final NestedInteger nestInteger : nestedList) {
      list.addAll(nestedInteger(nestInteger));
    }
  }

  private List<Integer> nestedInteger(final NestedInteger nestedInt) {
    final List<Integer> result = new ArrayList<>();
    if (nestedInt.isInteger()) {
      result.add(nestedInt.getInteger());
    } else {
      final List<NestedInteger> list = nestedInt.getList();
      for (final NestedInteger nI : list) {
        result.addAll(nestedInteger(nI));
      }
    }
    return result;
  }

  @Override
  public Integer next() {
    int res = list.get(i);
    i++;
    return res;
  }

  @Override
  public boolean hasNext() {
    return i != list.size();
  }
}
