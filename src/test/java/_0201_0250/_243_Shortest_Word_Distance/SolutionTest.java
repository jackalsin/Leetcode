package _0201_0250._243_Shortest_Word_Distance;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/21/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final String[] input = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(3, solution.shortestDistance(input, "coding", "practice"));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String[] input = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(1, solution.shortestDistance(input, "makes", "coding"));
  }
}
