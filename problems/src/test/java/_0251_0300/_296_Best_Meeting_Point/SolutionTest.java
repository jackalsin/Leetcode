package _0251_0300._296_Best_Meeting_Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/9/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test11() throws Exception {
    final int[][] board = {{1, 1}};
    assertEquals(1, solution.minTotalDistance(board));
  }

}
