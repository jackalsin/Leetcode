package lime._360_Sort_Transformed_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/12/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final int[] input = {-4, -2, 2, 4},
        actual = solution.sortTransformedArray(input, 1, 3, 5);
    assertArrayEquals(new int[]{3, 9, 15, 33}, actual, "actual = " + Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{-23, -5, 1, 7},
        solution.sortTransformedArray(input, -1, 3, 5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testAEquals(Solution solution) {
    final int[] input = {-4, -2, 2, 4},
        actual = solution.sortTransformedArray(input, 0, -1, 5);
    assertArrayEquals(new int[]{1, 3, 7, 9},
        actual, "actual = " + Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(Solution solution) {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{-7, -1, 11, 17},
        solution.sortTransformedArray(input, 0, 3, 5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase2(Solution solution) {
    final int[] input = {-99, -94, -90, -88, -84, -83, -79, -68, -58, -52, -52, -50, -47, -45, -35, -29, -5, -1, 9,
        12, 13, 25, 27, 33, 36, 38, 40, 46, 47, 49, 57, 57, 61, 63, 73, 75, 79, 97, 98},
        expected = {-24014, -21864, -20216, -19416, -17864, -17486, -16014, -14952, -14606, -12296, -9336, -9062,
            -8006, -7752, -7752, -7502, -7256, -6542, -6086, -5222, -4814, -4046, -4046, -4046, -3014, -2702, -2406,
            -2264, -1496, -1272, -1064, -782, -326, -326, -206, -102, 178, 178, 184},
        actual = solution.sortTransformedArray(input, -2, 44, -56);
    assertArrayEquals(expected, actual, "actual = " + Arrays.toString(actual) + "\n");
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}