package _0051_0100._079_Word_Search;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/13/2017.
 */
class SolutionTest {
  private Solution solution;
  private static final char[][] BOARD = new char[][]{
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
  };

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithOnlineCase() throws Exception {
    assertTrue(solution.exist(BOARD, "ASA"));
  }

  @Test
  void testWithOnlineCase2() throws Exception {
    assertTrue(solution.exist(BOARD, "ABC"));
  }

  @Test
  void testWithDupVisited() throws Exception {
    assertFalse(solution.exist(BOARD, "BFB"));
  }
}