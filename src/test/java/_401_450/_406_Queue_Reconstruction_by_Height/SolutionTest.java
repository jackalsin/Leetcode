package _401_450._406_Queue_Reconstruction_by_Height;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    final int[][] expected = {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
    assertArrayEquals(expected, solution.reconstructQueue(input));
  }

}
