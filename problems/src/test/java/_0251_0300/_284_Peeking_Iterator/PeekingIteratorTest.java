package _0251_0300._284_Peeking_Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class PeekingIteratorTest {
  private PeekingIterator peekingIterator;

  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void testOnline() throws Exception {
    peekingIterator = new PeekingIterator(Arrays.asList(1, 2, 3).iterator());
    assertEquals(Integer.valueOf(1), peekingIterator.next());
    assertEquals(Integer.valueOf(2), peekingIterator.peek());
    assertEquals(Integer.valueOf(2), peekingIterator.peek());
    assertEquals(Integer.valueOf(2), peekingIterator.next());
    assertEquals(Integer.valueOf(3), peekingIterator.next());
    assertFalse(peekingIterator.hasNext());
  }
}
