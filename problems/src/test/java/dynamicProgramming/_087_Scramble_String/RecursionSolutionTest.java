package dynamicProgramming._087_Scramble_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecursionSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new RecursionSolution();
  }

  @Test
  void testOnlineCase() throws Exception {
    assertTrue(solution.isScramble("rgtae", "great"));
  }

  @Test
  void testABC() throws Exception {
    assertTrue(solution.isScramble("abc", "bca"));
  }

  @Test
  void testTLECase() throws Exception {
    assertFalse(solution.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
  }

}