package _051_100._079_Word_Search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/13/2017.
 */
public class SolutionTest {
  private Solution solution;
  private static final char[][] BOARD = new char[][] {
      {'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}
  };

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineCase() throws Exception {
    assertTrue(solution.exist(BOARD, "ASA"));
  }

  @Test
  public void testWithOnlineCase2() throws Exception {
    assertTrue(solution.exist(BOARD, "ABC"));
  }

  @Test
  public void testWithDupVisited() throws Exception {
    assertFalse(solution.exist(BOARD, "BFB"));
  }
}