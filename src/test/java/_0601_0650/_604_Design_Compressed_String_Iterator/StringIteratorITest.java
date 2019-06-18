package _0601_0650._604_Design_Compressed_String_Iterator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringIteratorITest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final long startTime = System.nanoTime();
    StringIterator iterator = new StringIteratorI("L1e2t1C1o1d1e1");

    assertEquals('L', iterator.next());
    assertEquals('e', iterator.next());
    assertEquals('e', iterator.next());
    assertEquals('t', iterator.next());
    assertEquals('C', iterator.next());
    assertEquals('o', iterator.next());
    assertEquals('d', iterator.next());
    assertTrue(iterator.hasNext()); // return true
    assertEquals('e', iterator.next());
    assertFalse(iterator.hasNext()); // return false
    assertEquals(' ', iterator.next());
    final long endTime = System.nanoTime();
    System.out.println("Test time = " + (endTime - startTime) / 1E6);
  }
}