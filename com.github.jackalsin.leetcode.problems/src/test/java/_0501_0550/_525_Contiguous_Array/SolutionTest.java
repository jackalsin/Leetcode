package _0501_0550._525_Contiguous_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(2, solution.findMaxLength(new int[]{0, 1}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(2, solution.findMaxLength(new int[]{0, 1, 0}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase101(Solution solution) {
    assertEquals(2, solution.findMaxLength(new int[]{1, 0, 1}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int[] input = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
    assertEquals(6, solution.findMaxLength(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}