package _0451_0500._466_Count_The_Repetitions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BruteForceSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BruteForceSolution();
  }

  @Test
  void testOnlineCase1() {
    final String s1 = "acb", s2 = "ab";
    final int n1 = 4, n2 = 2;
    assertEquals(2, solution.getMaxRepetitions(s1, n1, s2, n2));
  }

  @Test
  void testOnlineCase2() {
    final String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", s2 = "a";
    final int n1 = 1000000, n2 = 1;

    assertEquals(100000000, solution.getMaxRepetitions(s1, n1, s2, n2));
  }
}

