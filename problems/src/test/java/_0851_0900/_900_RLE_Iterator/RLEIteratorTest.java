package _0851_0900._900_RLE_Iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RLEIteratorTest {
  private RLEIterator solution;

  @Test
  void testOnlineCase1() {
    final int[] input = {3,8,0,9,2,5};
    solution = new RLEIterator(input);
    assertEquals(8, solution.next(2));
    assertEquals(8, solution.next(1));
    assertEquals(5, solution.next(1));
    assertEquals(-1, solution.next(2));
  }
}