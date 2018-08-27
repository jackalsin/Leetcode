package _051_100._072_Edit_Distance;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/29/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithEmptyCouples() throws Exception {
    assertEquals(0, solution.minDistance("", ""));
  }

  @Test
  void testWithEmpty() throws Exception {
    assertEquals(5, solution.minDistance("", "word1"));
  }

  @Test
  void testWithCommonCase1() throws Exception {
    assertEquals(2, solution.minDistance("word", "wcd"));
  }
}