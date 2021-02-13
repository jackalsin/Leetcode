package apple.lookAheadIterator;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/12/2021
 */
class SolutionITest {

  @Test
  void testOnlineCase1() {
    final List<Integer> input = List.of(0, 1, 2, 3);
    final SolutionI<Integer> itr = new SolutionI<>(input.iterator());

    for (int i : input) {
      assertTrue(itr.hasNext());
      assertTrue(itr.hasNext());
      assertEquals(i, itr.lookAhead());
      assertEquals(i, itr.lookAhead());
      assertEquals(i, itr.next());
    }
    assertFalse(itr.hasNext());
    assertThrows(NoSuchElementException.class, () -> itr.next());
  }

}