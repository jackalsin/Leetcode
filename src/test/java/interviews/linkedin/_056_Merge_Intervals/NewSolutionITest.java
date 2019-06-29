package interviews.linkedin._056_Merge_Intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 6/27/2019
 */
class NewSolutionITest {

  private NewSolution solution;

  @BeforeEach
  void setUp() {
    solution = new NewSolutionI();
  }

  @Test
  void testWithOnlineCase1() {
    final int[][] actual = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,
        18}});
    assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, actual);
  }


}