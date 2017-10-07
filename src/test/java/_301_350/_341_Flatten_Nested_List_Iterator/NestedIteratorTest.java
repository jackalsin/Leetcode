package _301_350._341_Flatten_Nested_List_Iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import utils.nestedInteger.NestedInteger;
import utils.nestedInteger.NestedIntegerImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/6/2017.
 */
public class NestedIteratorTest {
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnlineCase1() throws Exception {
    // [[1,1],2,[1,1]]
    List<NestedInteger> input = List.of(
        new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1)),
        new NestedIntegerImpl(2),
        new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1))
    );
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
