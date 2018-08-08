package interviews.facebook._275_H_Index_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnline() {
    final int[] input = new int[]{0, 1, 3, 5, 6};
    assertEquals(3, solution.hIndex(input));
  }

  @Test
  void testZero() {
    final int[] input = new int[]{0};
    assertEquals(0, solution.hIndex(input));
  }

  @Test
  void testZeros() {
    final int[] input = new int[]{0, 0};
    assertEquals(0, solution.hIndex(input));
  }

  @Test
  void testOne() {
    final int[] input = new int[]{1};
    assertEquals(1, solution.hIndex(input));
  }

  @Test
  void testTwo() {
    final int[] input = new int[]{0, 1};
    assertEquals(1, solution.hIndex(input));
  }

}