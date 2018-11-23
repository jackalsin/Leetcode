package _0901_0950._911_Online_Election;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMapSolutionTest {
  private TopVotedCandidate solution;

  @Test
  void testOnlineCase1() {
    final int[] persons = {0, 1, 1, 0, 0, 1, 0}, times = {0, 5, 10, 15, 20, 25, 30};
    solution = new HashMapSolution(persons, times);
    assertEquals(0, solution.q(3));
    assertEquals(1, solution.q(12));
    assertEquals(1, solution.q(25));
    assertEquals(0, solution.q(15));
    assertEquals(0, solution.q(24));
    assertEquals(1, solution.q(8));
  }
}
