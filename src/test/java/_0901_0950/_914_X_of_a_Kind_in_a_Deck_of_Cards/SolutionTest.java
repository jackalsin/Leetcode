package _0901_0950._914_X_of_a_Kind_in_a_Deck_of_Cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {1, 2, 3, 4, 4, 3, 2, 1};
    assertTrue(solution.hasGroupsSizeX(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};
    assertTrue(solution.hasGroupsSizeX(input));
  }


}