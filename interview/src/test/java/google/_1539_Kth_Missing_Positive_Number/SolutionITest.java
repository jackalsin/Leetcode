package google._1539_Kth_Missing_Positive_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/10/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int arr[] = {2, 3, 4, 7, 11}, k = 5, expected = 9,
        actual = solution.findKthPositive(arr, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int arr[] = {1, 2, 3, 4}, k = 2, expected = 6,
        actual = solution.findKthPositive(arr, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int arr[] = {2}, k = 1, expected = 1,
        actual = solution.findKthPositive(arr, k);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ONSolution(),
        new OLogNSolution()
    );
  }
}