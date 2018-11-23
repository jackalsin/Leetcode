package _0401_0450._433_Minimum_Genetic_Mutation;

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
    final String start = "AACCGGTT", end = "AACCGGTA";
    final String[] bank = {"AACCGGTA"};
    assertEquals(1, solution.minMutation(start, end, bank));
  }

  @Test
  void testOnlineCase2() {
    final String start = "AACCGGTT", end = "AAACGGTA";
    final String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
    assertEquals(2, solution.minMutation(start, end, bank));
  }

  @Test
  void testOnlineCase3() {
    final String start = "AAAAACCC", end = "AACCCCCC";
    final String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
    assertEquals(3, solution.minMutation(start, end, bank));

  }


}