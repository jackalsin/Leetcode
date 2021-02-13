package apple.lookAheadIterator;

import java.util.Iterator;

/**
 * @author jacka
 * @version 1.0 on 2/12/2021
 */
public interface LookAheadIterator<E> extends Iterator<E> {
  /**
   * Returns the next element if present; otherwise, null.
   * Not move forward
   *
   * @return the next element
   */
  E lookAhead();
}
