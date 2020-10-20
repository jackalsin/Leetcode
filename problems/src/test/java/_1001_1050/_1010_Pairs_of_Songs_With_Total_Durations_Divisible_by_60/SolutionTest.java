package _1001_1050._1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60;

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
  void testOnlineCase1() {
    final int[] input = {30, 20, 150, 100, 40};
    assertEquals(3, solution.numPairsDivisibleBy60(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {60, 60, 60};
    assertEquals(3, solution.numPairsDivisibleBy60(input));
  }
}