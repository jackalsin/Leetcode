package uber._305_Number_of_Islands_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 2/8/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[][] input = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
    List<Integer> actual = solution.numIslands2(3, 3, input);
    List<Integer> expected = Arrays.asList(1, 1, 2, 3);
    assertEquals(expected, actual);
  }

  @Test
  void testFailedCase() throws Exception {
    final int[][] input = {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2},
        {0, 0}, {1, 1}};
    List<Integer> actual = solution.numIslands2(3, 3, input);
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
    assertEquals(expected, actual);
  }
}
