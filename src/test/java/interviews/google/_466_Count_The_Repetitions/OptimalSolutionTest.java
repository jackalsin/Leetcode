package interviews.google._466_Count_The_Repetitions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptimalSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new OptimalSolution();
  }

  @Test
  void testOnlineCase1() {
    final String s1 = "acb", s2 = "ab";
    final int n1 = 4, n2 = 2;
    assertEquals(2, solution.getMaxRepetitions(s1, n1, s2, n2));
  }

  @Test
  void testOnlineCase2() {
    final String s1 =
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", s2 =
        "a";
    final int n1 = 1000000, n2 = 1;
    assertEquals(100000000, solution.getMaxRepetitions(s1, n1, s2, n2));
  }

  @Test
  void testOnlineCase3() {
    final String s1 = "abc",
        s2 = "bac";
    final int n1 = 1000000, n2 = 1;
    assertEquals(500000, solution.getMaxRepetitions(s1, n1, s2, n2));
  }

  @Test
  void testOnlineCase4() {
    final String s1 = "abca",
        s2 = "bac";
    final int n1 = 1000000, n2 = 1;
    assertEquals(500000, solution.getMaxRepetitions(s1, n1, s2, n2));
  }

  @Test
  void testOnlineCase5() {
    final String s1 = "ab",
        s2 = "abab";
    final int n1 = 1000000, n2 = 1;
    assertEquals(500000, solution.getMaxRepetitions(s1, n1, s2, n2));
  }

  @Test
  void testBeforePattern() {
    final String s1 = "bacaba",
        s2 = "abacab";
    final int n1 = 3, n2 = 1;
    assertEquals(2, solution.getMaxRepetitions(s1, n1, s2, n2));
  }

  @Test
  void testAfterPattern() {
    final String s1 = "aaa", s2 = "aa";
    final int n1 = 3, n2 = 1;
    assertEquals(4, solution.getMaxRepetitions(s1, n1, s2, n2));
  }
}