package microsoft._079_Word_Search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;
  private static final char[][] BOARD = new char[][]{
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
  };

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithOnlineCase() {
    assertTrue(solution.exist(BOARD, "ASA"));
  }

  @Test
  void testWithOnlineCase2() {
    assertTrue(solution.exist(BOARD, "ABC"));
  }

  @Test
  void testWithDupVisited() {
    assertFalse(solution.exist(BOARD, "BFB"));
  }
}