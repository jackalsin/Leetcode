package _0251_0300._286_Walls_and_Gates;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/5/2017.
 */
public class SolutionTest {
  private Solution solution;
  private static final int INF = Integer.MAX_VALUE;

  @Before
  public void setUp() throws Exception {
//    solution = new NaiveBfsSolution();
    solution = new AdvancedBfsSolution();
  }

  @Test
  public void testOnline() throws Exception {
    final int[][] input = {
        {INF, -1, 0, INF},
        {INF, INF, INF, -1},
        {INF, -1, INF, -1},
        {0, -1, INF, INF}
    };

    final int[][] expected = {{3, -1, 0, 1},
        {2, 2, 1, -1},
        {1, -1, 2, -1},
        {0, -1, 3, 4}};
    solution.wallsAndGates(input);
    assertTrue(Arrays.deepEquals(expected, input));
  }

}
