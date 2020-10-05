package uber._341_Flatten_Nested_List_Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.nestedInteger.NestedInteger;
import utils.nestedInteger.NestedIntegerImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NestedIteratorTest {
  @BeforeEach
  void setUp() throws Exception {
  }

  @Test
  void testOnlineCase1() throws Exception {
    // [[1,1],2,[1,1]]
    List<NestedInteger> input =
        List.of(
            new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1)),
            new NestedIntegerImpl(2),
            new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1)));
    NestedIterator nestedIterator = new NestedIterator(input);
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
