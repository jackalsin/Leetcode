package _351_400._373_Find_K_Pairs_with_Smallest_Sums;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums1 = {1, 7, 11};
    final int[] nums2 = {2, 4, 6};
    List<int[]> expected = List.of(new int[]{1, 2}, new int[]{1, 4}, new int[]{1, 6});
    List<int[]> actual = solution.kSmallestPairs(nums1, nums2, 3);
    ListOfArrayEquals(expected, actual);
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums1 = {1, 1, 2};
    final int[] nums2 = {1, 2, 3};
    List<int[]> expected = List.of(new int[]{1, 1}, new int[]{1, 1});
    List<int[]> actual = solution.kSmallestPairs(nums1, nums2, 2);
    ListOfArrayEquals(expected, actual);
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] nums1 = {1, 2, 3};
    final int[] nums2 = {1, 1, 2};
    List<int[]> expected = List.of(new int[]{1, 1}, new int[]{1, 1});
    List<int[]> actual = solution.kSmallestPairs(nums1, nums2, 2);
    ListOfArrayEquals(expected, actual);
  }

  @Test
  public void testOnlineCase4() throws Exception {
    final int[] nums1 = {1, 2};
    final int[] nums2 = {3};
    List<int[]> expected = List.of(new int[]{1, 3}, new int[]{2, 3});
    List<int[]> actual = solution.kSmallestPairs(nums1, nums2, 2);
    ListOfArrayEquals(expected, actual);
  }

  @Test
  public void testFailedOnEmpty() throws Exception {
    final int[] nums1 = {};
    final int[] nums2 = {3, 5, 7, 9};
    List<int[]> expected = List.of();
    List<int[]> actual = solution.kSmallestPairs(nums1, nums2, 1);
    ListOfArrayEquals(expected, actual);
  }

  @Test
  public void testFailedOnKLargerThanActual() throws Exception {
    final int[] nums1 = {1, 1, 2};
    final int[] nums2 = {1, 2, 3};
    List<int[]> expected = List.of(new int[]{1, 1}, new int[]{1, 1}, new int[]{2, 1}, new int[]{1, 2}, new int[]{1, 2},
        new int[]{2, 2}, new int[]{1, 3}, new int[]{1, 3}, new int[]{2, 3});
    List<int[]> expected2 = List.of(new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 2}, new int[]{1, 2}, new int[]{2, 1},
        new int[]{1, 3}, new int[]{2, 2}, new int[]{1, 3}, new int[]{2, 3});
    List<int[]> actual = solution.kSmallestPairs(nums1, nums2, 10);
    ListOfArrayEquals(expected2, actual);
  }

  private static void ListOfArrayEquals(List<int[]> expected, List<int[]> actual) {
    assert (actual.size() == expected.size());
    for (int i = 0; i < actual.size(); i++) {
      assertArrayEquals(expected.get(i), actual.get(i));
    }
  }
}