package _0351_0400._390_Elimination_Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;
  @BeforeEach
  void setUp() {
    solution = new CountSolution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(6, solution.lastRemaining(9));
  }
}