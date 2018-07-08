package interviews.microsoft._213_House_Robber_II;

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
  void testEmpty() {
    assertEquals(0, solution.rob(new int[]{}));
  }

  @Test
  void testOne() {
    assertEquals(1, solution.rob(new int[]{1}));
  }

  @Test
  void testTwo() {
    final int[] input = new int[]{1, 2};
    assertEquals(2, solution.rob(input));
  }


  @Test
  void testThree() {
    final int[] input = new int[]{1, 2, 3};
    assertEquals(3, solution.rob(input));
  }

  @Test
  void test131() {
    final int[] input = new int[]{1, 3, 1};
    assertEquals(3, solution.rob(input));
  }

  @Test
  void testMaxHead() {
    final int[] input = new int[]{6, 1, 5};
    assertEquals(6, solution.rob(input));
  }

  @Test
  void testMaxTail() {
    final int[] input = new int[]{6, 1, 11};
    assertEquals(11, solution.rob(input));
  }

  @Test
  void testFailed1() {
    final int[] input = new int[]{1, 2, 1, 0};
    assertEquals(2, solution.rob(input));
  }
}