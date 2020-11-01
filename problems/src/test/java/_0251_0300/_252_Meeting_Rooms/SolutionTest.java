package _0251_0300._252_Meeting_Rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmpty() throws Exception {
    final int[][] input = new int[][]{};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  void testOne() throws Exception {
    final int[][] input = {{3, 6}};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  void testMulti() throws Exception {
    final int[][] input = {{3, 6}, {6, 20}};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  void testNegative() throws Exception {
    final int[][] input = {{3, 6}, {3, 20}};
    assertFalse(solution.canAttendMeetings(input));
  }

}
