package _0051_0100._087_Scramble_String;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/28/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
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
