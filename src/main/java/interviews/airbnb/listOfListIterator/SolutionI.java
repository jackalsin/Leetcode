package interviews.airbnb.listOfListIterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public final class SolutionI implements Iterator<Integer> {
  private Iterator<List<Integer>> rowItr;
  private Iterator<Integer> colItr;

  public SolutionI(final List<List<Integer>> input) {
    rowItr = input.iterator();
    colItr = Collections.emptyIterator();
  }

  @Override
  public boolean hasNext() {
    while ((colItr == null || !colItr.hasNext()) && rowItr.hasNext()) {
      final List<Integer> colItoCandidate = rowItr.next();
      colItr = colItoCandidate == null ? null : colItoCandidate.iterator();
    }
    return colItr != null && colItr.hasNext();
  }

  @Override
  public Integer next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return colItr.next();
  }

  @Override
  public void remove() {
    if (colItr != null) {
      colItr.remove();
    }
  }
}
