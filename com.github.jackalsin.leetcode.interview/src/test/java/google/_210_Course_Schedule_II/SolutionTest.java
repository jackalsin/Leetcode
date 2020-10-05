package google._210_Course_Schedule_II;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    final int[][] courses = new int[][]{};
    final int numCourses = 0;
    assertArrayEquals(new int[0], solution.findOrder(numCourses, courses));
  }

  @Test
  public void testOnlineCase() throws Exception {
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

  @Test
  public void testOnlineCase2() throws Exception {
    final int[][] courses = new int[][]{
        {1, 0}
    };
    final int numCourses = 2;

    int[] actual = solution.findOrder(numCourses, courses);
    assertArrayEquals(new int[]{0, 1}, actual);
  }
}