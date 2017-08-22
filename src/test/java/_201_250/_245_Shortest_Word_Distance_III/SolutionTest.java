package _201_250._245_Shortest_Word_Distance_III;

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
  public void testMakesAndMakes() throws Exception {
    final String[] input = new String[] {"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(1, solution.shortestWordDistance(input, "makes", "coding"));
    assertEquals(3, solution.shortestWordDistance(input, "makes", "makes"));
  }
}
