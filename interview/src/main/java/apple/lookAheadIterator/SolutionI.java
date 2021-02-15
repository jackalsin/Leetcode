package apple.lookAheadIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author jacka
 * @version 1.0 on 2/12/2021
 */
public final class SolutionI<E> implements LookAheadIterator<E> {
  private final Iterator<E> itr;
  private E next = null;

  public SolutionI(final Iterator<E> itr) {
    this.itr = itr;
    if (itr != null && itr.hasNext()) {
      next = itr.next();
    }
  }

  @Override
  public E lookAhead() {
    return next;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }

  @Override
  public E next() {
    final E result = next;
    if (!itr.hasNext() && next == null) {
      throw new NoSuchElementException();
    }
    next = itr.hasNext() ? itr.next() : null;
    return result;
  }
}
