package apple._341_Flatten_Nested_List_Iterator;

import java.util.Iterator;

/**
 * @author jacka
 * @version 1.0 on 2/13/2021
 */
public interface NestedIterator extends Iterator<Integer> {

  @Override
  Integer next();

  @Override
  boolean hasNext();
}
