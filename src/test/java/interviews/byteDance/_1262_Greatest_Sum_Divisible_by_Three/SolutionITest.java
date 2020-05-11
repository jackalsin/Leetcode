package interviews.byteDance._1262_Greatest_Sum_Divisible_by_Three;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int nums[] = {3, 6, 5, 1, 8}, expected = 18;
    assertEquals(expected, solution.maxSumDivThree(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int nums[] = {4}, expected = 0;
    assertEquals(expected, solution.maxSumDivThree(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int nums[] = {1, 2, 3, 4, 4}, expected = 12;
    assertEquals(expected, solution.maxSumDivThree(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int nums[] = {5, 2, 2, 2}, expected = 9;
    assertEquals(expected, solution.maxSumDivThree(nums));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}