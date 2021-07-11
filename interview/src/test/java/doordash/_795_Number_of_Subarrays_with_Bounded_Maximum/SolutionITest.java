package doordash._795_Number_of_Subarrays_with_Bounded_Maximum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/2/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int A[] = {2, 1, 4, 3}, L = 2, R = 3;
    assertEquals(3, solution.numSubarrayBoundedMax(A, L, R));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int A[] = {7, 3, 6, 7, 1}, L = 1, R = 4;
    assertEquals(2, solution.numSubarrayBoundedMax(A, L, R));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int A[] = {2, 9, 2, 5, 6}, L = 2, R = 8;
    assertEquals(7, solution.numSubarrayBoundedMax(A, L, R));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}