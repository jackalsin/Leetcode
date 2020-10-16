package _0951_1000._995_Minimum_Number_of_K_Consecutive_Bit_Flips;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int A[] = {0, 1, 0}, K = 1, expected = 2;
    assertEquals(expected, solution.minKBitFlips(A, K));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int A[] = {1, 1, 0}, K = 2, expected = -1;
    assertEquals(expected, solution.minKBitFlips(A, K));
//    No matter how we flip subarrays of size 2, we can 't make the array become [1,1,1].
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int A[] = {0, 0, 0, 1, 0, 1, 1, 0}, K = 3, expected = 3;
    assertEquals(expected, solution.minKBitFlips(A, K));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}