package _301_350._323_Number_of_Connected_Components_in_an_Undirected_Graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int n = 5;
    final int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
    assertEquals(2, solution.countComponents(5, edges));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int n = 5;
    final int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
    assertEquals(1, solution.countComponents(5, edges));
  }


}
