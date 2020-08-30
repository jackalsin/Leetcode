package _0751_0800._786_K_th_Smallest_Prime_Fraction;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int A[] = {1, 2, 3, 5}, K = 3,
        expected[] = {2, 5}, actual[] = solution.kthSmallestPrimeFraction(A, K);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new PqSolution()
    );
  }
}