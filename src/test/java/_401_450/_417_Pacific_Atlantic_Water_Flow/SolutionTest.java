package _401_450._417_Pacific_Atlantic_Water_Flow;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
    final List<int[]> expected = List.of(
        new int[]{0, 4}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 2}, new int[]{3, 0}, new int[]{3, 1}, new int[]{4, 0});
    final List<int[]> actual = solution.pacificAtlantic(matrix);
    assertTrue(listArrayEquals(expected, actual));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[][] matrix = {
        {1, 2},
        {4, 3}};
    final List<int[]> expected = List.of(
        new int[]{1, 0}, new int[]{0, 1}, new int[]{1, 1});
    final List<int[]> actual = solution.pacificAtlantic(matrix);
    assertTrue(listArrayEquals(expected, actual));
  }

  private static boolean listArrayEquals(List<int[]> expected, List<int[]> actual) {
    if (expected.size() != actual.size()) return false;
    final List<int[]> expectedCopy = new ArrayList<>(expected), actualCopy = new ArrayList<>(actual);
    expectedCopy.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return Integer.compare(o1[1], o2[1]);
      }
      return Integer.compare(o1[0], o2[0]);
    });

    actualCopy.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return Integer.compare(o1[1], o2[1]);
      }
      return Integer.compare(o1[0], o2[0]);
    });

    for (int i = 0; i < actual.size(); i++) {
      if (!Arrays.equals(expectedCopy.get(i), actualCopy.get(i))) {
        return false;
      }
    }
    return true;

  }

}