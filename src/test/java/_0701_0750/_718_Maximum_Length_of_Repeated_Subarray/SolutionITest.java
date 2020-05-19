package _0701_0750._718_Maximum_Length_of_Repeated_Subarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/18/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] a = {1, 2, 3, 2, 1}, b = {3, 2, 1, 4, 7};
    assertEquals(3, solution.findLength(a, b));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] a = {0, 1, 1, 1, 1}, b = {1, 0, 1, 0, 1};
    assertEquals(2, solution.findLength(a, b));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] a = {1, 0, 0, 0, 1}, b = {1, 0, 0, 1, 1};
    assertEquals(3, solution.findLength(a, b));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}