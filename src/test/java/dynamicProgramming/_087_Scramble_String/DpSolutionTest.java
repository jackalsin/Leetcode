package dynamicProgramming._087_Scramble_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DpSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new DpSolution();
  }

  @Test
  void testOnlineCase() {
    assertTrue(solution.isScramble("rgtae", "great"));
  }

  @Test
  void testABC() {
    assertTrue(solution.isScramble("abc", "bca"));
  }

  @Test
  void testTLECase() {
    assertFalse(solution.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
  }

}