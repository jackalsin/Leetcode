package interviews.facebook._274_H_Index;

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
    final int[] input = new int[]{3, 0, 6, 1, 5};
    assertEquals(3, solution.hIndex(input));
  }

  @Test
  void testOne() {
    final int[] input = new int[]{0};
    assertEquals(0, solution.hIndex(input));
  }

  @Test
  void testEmpty() {
    final int[] input = new int[]{};
    assertEquals(0, solution.hIndex(input));
  }

  @Test
  void test100() {
    final int[] input = new int[]{100};
    assertEquals(1, solution.hIndex(input));
  }
}