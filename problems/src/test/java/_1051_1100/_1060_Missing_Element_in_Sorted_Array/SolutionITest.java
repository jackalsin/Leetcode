package _1051_1100._1060_Missing_Element_in_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/10/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int A[] = {4, 7, 9, 10}, K = 1;
    assertEquals(5, solution.missingElement(A, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int A[] = {4, 7, 9, 10}, K = 3, expected = 8;
    assertEquals(expected, solution.missingElement(A, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int A[] = {1, 2, 4}, K = 3, expected = 6;
    assertEquals(expected, solution.missingElement(A, K));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ONSolution(),
        new BinarySearchSolution()
    );
  }
}