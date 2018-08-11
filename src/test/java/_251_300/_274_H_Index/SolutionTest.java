package _251_300._274_H_Index;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnline() {
    final int[] input = new int[]{3, 0, 6, 1, 5};
    assertEquals(3, solution.hIndex(input));
  }

  @Test
  void testOne() {
    final int[] input = new int[]{0};
    assertEquals(0, solution.hIndex(input));
  }

}
