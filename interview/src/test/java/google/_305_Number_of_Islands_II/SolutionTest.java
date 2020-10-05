package google._305_Number_of_Islands_II;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[][] input = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
    List<Integer> actual = solution.numIslands2(3, 3, input);
    List<Integer> expected = Arrays.asList(1, 1, 2, 3);
    assertEquals(expected, actual);
  }

  @Test
  public void testFailedCase() {
    final int[][] input = {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2},
        {0, 0}, {1, 1}};
    List<Integer> actual = solution.numIslands2(3, 3, input);
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
    assertEquals(expected, actual);
  }
}
