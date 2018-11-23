package _0251_0300._281_Zigzag_Iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/3/2017.
 */
public class ZigzagIterator {
  private Deque<Iterator<Integer>> iterators;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    iterators = new ArrayDeque<>();
    iterators.add(v1.iterator());
    iterators.add(v2.iterator());
  }

  public int next() {
    while (!iterators.isEmpty()) {
      if (iterators.peek().hasNext()) {
        int rtn = iterators.peek().next();
        iterators.add(iterators.remove());
        return rtn;
      } else {
        iterators.remove();
      }
    }
    return 0;
  }

  public boolean hasNext() {
    for (Iterator<Integer> itr : iterators) {
      if (itr.hasNext()) return true;
    }
    return false;
  }
}
