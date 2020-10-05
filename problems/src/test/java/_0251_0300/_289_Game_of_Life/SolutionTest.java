package _0251_0300._289_Game_of_Life;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline1() throws Exception {
    final int[][] input = {{1, 1}, {1, 0}};
    solution.gameOfLife(input);
    final int[][] expected = {{1, 1}, {1, 1}};
    assertTrue(Arrays.deepEquals(expected, input));
  }

}
