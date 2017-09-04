package _251_300._284_Peeking_Iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class PeekingIteratorTest {
  private PeekingIterator peekingIterator;
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnline() throws Exception {
    peekingIterator = new PeekingIterator(Arrays.asList(1, 2, 3).iterator());
    assertEquals(new Integer(1), peekingIterator.next());
    assertEquals(new Integer(2), peekingIterator.peek());
    assertEquals(new Integer(2), peekingIterator.peek());
    assertEquals(new Integer(2), peekingIterator.next());
    assertEquals(new Integer(3), peekingIterator.next());
    assertFalse(peekingIterator.hasNext());
  }
}
