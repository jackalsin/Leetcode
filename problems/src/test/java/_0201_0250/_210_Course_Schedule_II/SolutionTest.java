package _0201_0250._210_Course_Schedule_II;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

/**
 * @author jacka
 * @version 1.0 on 8/26/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    final int[][] courses = new int[][]{};
    final int numCourses = 0;
    assertArrayEquals(new int[0], solution.findOrder(numCourses, courses));
  }

  @Test
  void testOnlineCase() {
    final int[][] courses = new int[][]{
        {1, 0}, {2, 0}, {3, 1}, {3, 2}
    };
    final int numCourses = 4;

    int[] actual = solution.findOrder(numCourses, courses);
    if (!Arrays.equals(new int[]{0, 1, 2, 3}, actual) && !Arrays.equals(new int[]{0, 2, 1, 3},
        actual)) {
      fail();
    }
  }
}
