package interviews.linkedin._796_Rotate_String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KmpSolutionTest {

  // test of getNext()
  @Test
  void testGetNextAbcabcd() {
    final String pattern = "abcabcd";
    final int[] next = KmpSolution.getNext(pattern),
        expected = {-1, 0, 0, 0, 1, 2, 3};
    assertArrayEquals(expected, next);
  }

}