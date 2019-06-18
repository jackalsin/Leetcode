package _0601_0650._604_Design_Compressed_String_Iterator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringIteratorIITest {

  @Test
  void testOnlineCase1() throws Exception {
    StringIterator iterator = new StringIteratorII("L1e2t1C1o1d1e1");
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
  }

  @Test
  void testEmpty() {
    final StringIterator iterator = new StringIteratorII("");
    assertFalse(iterator.hasNext());
    assertEquals(' ', iterator.next());
    assertFalse(iterator.hasNext());
  }


  @Test
  void testL13E4() {
    final StringIterator iterator = new StringIteratorII("L13E4");
    for (int i = 0; i < 13; i++) {
      assertTrue(iterator.hasNext());
      assertEquals('L', iterator.next());
    }
    for (int i = 0; i < 4; i++) {
      assertTrue(iterator.hasNext());
      assertEquals('E', iterator.next());
    }
    assertFalse(iterator.hasNext());
  }
}