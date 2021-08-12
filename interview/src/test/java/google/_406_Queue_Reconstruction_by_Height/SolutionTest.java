package google._406_Queue_Reconstruction_by_Height;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}, output =
        {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
    assertTrue(Arrays.deepEquals(output, solution.reconstructQueue(input)));
  }
}
