package _0301_0350._341_Flatten_Nested_List_Iterator;

import java.util.Iterator;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public interface NestedIterator extends Iterator<Integer> {

  @Override
  boolean hasNext();

  @Override
  Integer next();
}
