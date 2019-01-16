package interviews.uber._283_Move_Zeroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {0,1,0,3,12}, expected = {1,3,12,0,0};
    solution.moveZeroes(input);
    assertArrayEquals(expected, input);
  }  @Test
  void testOnlineCase2() {
    final int[] input = {1}, expected = {1};
    solution.moveZeroes(input);
    assertArrayEquals(expected, input);
  }
}