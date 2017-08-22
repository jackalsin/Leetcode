package _201_250._243_Shortest_Word_Distance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/21/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[] input = new String[] {"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(3, solution.shortestDistance(input, "coding", "practice"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String[] input = new String[] {"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(1, solution.shortestDistance(input, "makes", "coding"));
  }
}
