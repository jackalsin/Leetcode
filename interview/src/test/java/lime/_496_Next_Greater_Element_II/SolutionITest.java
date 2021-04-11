package lime._496_Next_Greater_Element_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/11/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) throws Exception {
    final int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2}, expected = {-1, 3, -1},
        actual = solution.nextGreaterElement(nums1, nums2);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) throws Exception {
    final int[] nums1 = {2, 4}, nums2 = {1, 2, 3, 4}, expected = {3, -1},
        actual = solution.nextGreaterElement(nums1, nums2);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final int[] nums1 = {2, 1, 3}, nums2 = {2, 3, 1}, expected = {3, -1, -1},
        actual = solution.nextGreaterElement(nums1, nums2);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}