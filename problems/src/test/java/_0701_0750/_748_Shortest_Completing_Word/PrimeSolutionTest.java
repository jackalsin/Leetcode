package _0701_0750._748_Shortest_Completing_Word;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new PrimeSolution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final String licensePlate = "1s3 PSt", expected = "steps";
    final String[] words = {"step", "steps", "stripe", "stepple"};
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String licensePlate = "1s3 456", expected = "pest";
    final String[] words = {"looks", "pest", "stew", "show"};
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }

}