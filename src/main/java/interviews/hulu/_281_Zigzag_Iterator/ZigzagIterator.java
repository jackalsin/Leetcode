package interviews.hulu._281_Zigzag_Iterator;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 12/18/2019
 */
public final class ZigzagIterator implements Solution {
  private int count = -1, i = 0, j = 0;
  private final List<Integer> v1, v2;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    this.v1 = v1;
    this.v2 = v2;
  }

  public int next() {
    final boolean hasNext = hasNext();
    assert hasNext;
    count++;
    if (i == v1.size()) {
      return v2.get(j++);
    } else if (j == v2.size()) {
      return v1.get(i++);
    } else {
      if (count % 2 == 0) {
        return v1.get(i++);
      } else {
        return v2.get(j++);
      }
    }
  }

  public boolean hasNext() {
    return i < v1.size() || j < v2.size();
  }
}
