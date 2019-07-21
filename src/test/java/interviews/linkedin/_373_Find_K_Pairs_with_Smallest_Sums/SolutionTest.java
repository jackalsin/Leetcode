package interviews.linkedin._373_Find_K_Pairs_with_Smallest_Sums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] nums1 = {1, 7, 11};
    final int[] nums2 = {2, 4, 6};
    List<List<Integer>> expected = List.of(List.of(1, 2), List.of(1, 4), List.of(1, 6));
    List<List<Integer>> actual = solution.kSmallestPairs(nums1, nums2, 3);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] nums1 = {1, 1, 2};
    final int[] nums2 = {1, 2, 3};
    List<List<Integer>> expected = List.of(List.of(1, 1), List.of(1, 1));
    List<List<Integer>> actual = solution.kSmallestPairs(nums1, nums2, 2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] nums1 = {1, 2, 3};
    final int[] nums2 = {1, 1, 2};
    List<List<Integer>> expected = List.of(List.of(1, 1), List.of(1, 1));
    List<List<Integer>> actual = solution.kSmallestPairs(nums1, nums2, 2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int[] nums1 = {1, 2};
    final int[] nums2 = {3};
    List<List<Integer>> expected = List.of(List.of(1, 3), List.of(2, 3));
    List<List<Integer>> actual = solution.kSmallestPairs(nums1, nums2, 2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedOnEmpty(Solution solution) {
    final int[] nums1 = {};
    final int[] nums2 = {3, 5, 7, 9};
    List<List<Integer>> expected = List.of();
    List<List<Integer>> actual = solution.kSmallestPairs(nums1, nums2, 1);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedOnKLargerThanActual(Solution solution) {
    final int[] nums1 = {1, 1, 2};
    final int[] nums2 = {1, 2, 3};
    final Set<List<List<Integer>>> expected = Set.of(
        List.of(List.of(1, 1), List.of(1, 1), List.of(2, 1), List.of(1, 2), List.of(1, 2),
            List.of(2, 2), List.of(1, 3), List.of(1, 3), List.of(2, 3)),
        List.of(List.of(1, 1), List.of(1, 1), List.of(1, 2), List.of(1, 2), List.of(2, 1),
            List.of(1, 3), List.of(2, 2), List.of(1, 3), List.of(2, 3))
    );
    List<List<Integer>> actual = solution.kSmallestPairs(nums1, nums2, 10);
    assertTrue(expected.contains(actual));
  }


  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}