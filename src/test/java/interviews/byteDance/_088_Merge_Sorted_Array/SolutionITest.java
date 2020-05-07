package interviews.byteDance._088_Merge_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testBothFinish(Solution solution) {
    final int[] nums1 = new int[]{1, 3, 5, 0, 0, 0};
    final int[] nums2 = new int[]{2, 4, 6};
    solution.merge(nums1, 3, nums2, 3);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1FinishFirst(Solution solution) {
    final int[] nums1 = new int[]{1, 0, 0, 0};
    final int[] nums2 = new int[]{-1, 2, 4};
    final int[] expected = new int[]{-1, 1, 2, 4};
    solution.merge(nums1, 1, nums2, 3);
    assertArrayEquals(expected, nums1);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test2FinishFirst(Solution solution) {
    final int[] nums1 = new int[]{1, 3, 4, 0};
    final int[] nums2 = new int[]{2};
    final int[] expected = new int[]{1, 2, 3, 4};
    solution.merge(nums1, 3, nums2, 1);
    assertArrayEquals(expected, nums1);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}