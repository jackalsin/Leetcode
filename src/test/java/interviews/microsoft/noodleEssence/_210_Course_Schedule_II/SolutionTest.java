package interviews.microsoft.noodleEssence._210_Course_Schedule_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmpty() throws Exception {
    final int[][] courses = new int[][]{};
    final int numCourses = 0;
    assertArrayEquals(new int[0], solution.findOrder(numCourses, courses));
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[][] courses = new int[][]{
        {1, 0}, {2, 0}, {3, 1}, {3, 2}
    };
    final int numCourses = 4;

    int[] actual = solution.findOrder(numCourses, courses);
    if (!Arrays.equals(new int[]{0, 1, 2, 3}, actual) && !Arrays.equals(new int[]{0, 2, 1, 3},
        actual)) {
      fail("");
    }
  }
}