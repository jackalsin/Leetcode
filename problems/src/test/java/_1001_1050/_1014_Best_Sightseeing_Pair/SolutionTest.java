package _1001_1050._1014_Best_Sightseeing_Pair;

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
    final int[] input = {8, 1, 5, 2, 6};
    assertEquals(11, solution.maxScoreSightseeingPair(input));
  }
}