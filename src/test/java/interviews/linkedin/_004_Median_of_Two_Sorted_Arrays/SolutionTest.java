package interviews.linkedin._004_Median_of_Two_Sorted_Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/17/2019
 */
class SolutionTest {

  private final int[] nums1 = new int[]{1, 3, 5, 7};
  private final int[] nums2 = new int[]{2, 4, 6, 8};
  private final int[] nums3 = new int[]{3, 4, 5};
  private final int[] nums4 = new int[]{1, 2};

  private final int[] nums5 = new int[]{1, 2, 3};
  private final int[] nums6 = new int[]{4, 5};

  private final int[] nums7 = new int[0];
  private final int[] nums8 = new int[]{1};


  @ParameterizedTest
  @MethodSource("solutionStream")
  void findMedianSortedArrays(Solution solution) {
    assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void findMedianSortedArrays2(Solution solution) {
    assertEquals(4d, solution.findMedianSortedArrays(nums3, nums2), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void findMedianSortedArrays3(Solution solution) {
    assertEquals(3, solution.findMedianSortedArrays(nums3, nums4), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void findMedianSortedArrays4(Solution solution) {
    assertEquals(3, solution.findMedianSortedArrays(nums5, nums6), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void findMedianSortedArrays5(Solution solution) {
    assertEquals(1, solution.findMedianSortedArrays(nums7, nums8), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void findMedianSortedArrays6(Solution solution) {
    int[] nums1 = new int[]{1, 2};
    int[] nums2 = new int[]{3, 4};
    assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 1e-8);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}