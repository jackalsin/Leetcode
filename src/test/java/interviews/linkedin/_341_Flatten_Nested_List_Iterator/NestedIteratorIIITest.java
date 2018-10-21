package interviews.linkedin._341_Flatten_Nested_List_Iterator;

import org.junit.jupiter.api.Test;
import utils.nestedInteger.NestedInteger;
import utils.nestedInteger.NestedIntegerImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
class NestedIteratorIIITest {
  @Test
  void testOnlineCase1() {
    // [[1,1],2,[1,1]]
    List<NestedInteger> input = List.of(
        new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1)),
        new NestedIntegerImpl(2),
        new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1))
    );
    NestedIterator nestedIterator = new NestedIteratorIII(input);
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(1), nestedIterator.next());
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(1), nestedIterator.next());
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(2), nestedIterator.next());
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(1), nestedIterator.next());
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(1), nestedIterator.next());
    assertFalse(nestedIterator.hasNext());
    assertFalse(nestedIterator.hasNext());
  }

}