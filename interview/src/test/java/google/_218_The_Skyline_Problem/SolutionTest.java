package google._218_The_Skyline_Problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SolutionTest {
  private Solution solution;
  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testFailedCase() throws Exception {
    final int[][] input = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
    final List<int[]> expected = Arrays.asList(new int[]{2,10}, new int[]{3,15}, new int[]{7,12},
        new int[]{12,0}, new int[]{15,10}, new int[]{20,8}, new int[]{24, 0});
    solution.getSkyline(input);
  }

  @Test
  void testFailedTestCase() throws Exception {
    final int[][] input = new int[][] {{0, 3, 3},{1, 5, 3},{2, 4, 3},{3, 7, 3}};
    final List<int[]> expected = Arrays.asList(
        new int[]{0, 3}, new int[]{7, 0});
    final List<int[]> actual = solution.getSkyline(input);
    for (int [] child: actual) {
      System.out.println(Arrays.toString(child));
    }
  }

  @Test
  void testFailedCase2() {
    final int[][] input = new int[][] {{0,2,3},{2,5,3}};
    final List<int[]> expected = List.of(new int[]{0, 3}, new int[]{5, 0});
    final List<int[]> actual = solution.getSkyline(input);
    actual.forEach(Arrays::toString);
  }

}