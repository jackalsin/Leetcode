package _0751_0800._755_Pour_Water;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {2, 1, 1, 2, 1, 2, 2}, expect = {2, 2, 2, 3, 2, 2, 2}, actual = solution.pourWater(input, 4, 3);
    assertArrayEquals(expect, actual);
  }

  @Test
  void testFailedCase1() {
    final int[] input = {1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1},
        expect = {4, 4, 4, 4, 3, 3, 3, 3, 3, 4, 3, 2, 1},
        actual = solution.pourWater(input, 10, 2);
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expect, actual);
  }
}