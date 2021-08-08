package _1301_1350._1343_Number_of_Sub_arrays_of_Size_K_and_Average_Greater_than_or_Equal_to_Threshold;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/7/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int arr[] = {2, 2, 2, 2, 5, 5, 5, 8}, k = 3, threshold = 4,
        expected = 3, actual = solution.numOfSubarrays(arr, k, threshold);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int arr[] = {1, 1, 1, 1, 1}, k = 1, threshold = 0,
        expected = 5, actual = solution.numOfSubarrays(arr, k, threshold);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int arr[] = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, k = 3, threshold = 5,
        expected = 6, actual = solution.numOfSubarrays(arr, k, threshold);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int arr[] = {7, 7, 7, 7, 7, 7, 7}, k = 7, threshold = 7,
        expected = 1, actual = solution.numOfSubarrays(arr, k, threshold);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int arr[] = {4, 4, 4, 4}, k = 4, threshold = 1,
        expected = 1, actual = solution.numOfSubarrays(arr, k, threshold);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}