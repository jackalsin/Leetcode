package _251_300._284_Peeking_Iterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public final class PeekingIterator implements Iterator<Integer> {
  private Integer cur = null;

  private final Iterator<Integer> iterator;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    if (this.iterator.hasNext()) cur = this.iterator.next();
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if (cur == null) {
      cur = iterator.next();
    }
    return cur;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    int result = cur;
    cur = iterator.hasNext() ? iterator.next() : null;
    return result;
  }

  @Override
  public boolean hasNext() {
    return cur != null;
  }
}
