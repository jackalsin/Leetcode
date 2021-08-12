package google._289_Game_of_Life;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
//    solution = new LeetCodeSolution();
    solution = new InterviewSolution();
  }

  @Test
  public void testOnline1() throws Exception {
    final int[][] input = {{1, 1}, {1, 0}};
    solution.gameOfLife(input);
    final int[][] expected = {{1, 1}, {1, 1}};
    assertTrue(Arrays.deepEquals(expected, input));
  }
}
