package _0451_0500._496_Next_Greater_Element_I;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) throws Exception {
    final int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2}, expected = {-1, 3, -1};
    assertArrayEquals(expected, solution.nextGreaterElement(nums1, nums2));
  }
}