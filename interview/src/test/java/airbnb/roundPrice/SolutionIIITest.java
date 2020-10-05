package airbnb.roundPrice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionIII();
  }

  @Test
  void testOnlineCase1() {
    final double[] input = {1.2, 2.3, 3.4};
    final int[] expected = {1, 2, 4}, actual = solution.roundMinAbs(input);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final double[] input = {1.2, 2.5, 3.6, 4.0};
    final int[] expected = {1, 2, 4, 4}, actual = solution.roundMinAbs(input);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testEmpty() {
    final double[] input = {};
    final int[] expected = {}, actual = solution.roundMinAbs(input);
    assertArrayEquals(expected, actual);
  }
}