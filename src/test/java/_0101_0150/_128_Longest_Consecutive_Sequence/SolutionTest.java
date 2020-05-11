package _0101_0150._128_Longest_Consecutive_Sequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[] input = new int[]{100, 4, 200, 1, 3, 2};
    assertEquals(4, solution.longestConsecutive(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
    final int[] dup = new int[input.length];
    System.arraycopy(input, 0, dup, 0, dup.length);
    Arrays.sort(dup);
    assertEquals(5, solution.longestConsecutive(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] input = new int[]{-2, -3, -3, 7, -3, 0, 5, 0, -8, -4, -1, 2};
    final int[] dup = new int[input.length];
    System.arraycopy(input, 0, dup, 0, dup.length);
    Arrays.sort(dup);
    assertEquals(5, solution.longestConsecutive(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[] input = new int[]{
        4, 2, 2, -4, 0, -2, 4, -3, -4, -4, -5,
        1, 4, -9, 5, 0, 6, -8, -1, -3, 6, 5, -8,
        -1, -5, -1, 2, -9, 1};
    final int[] dup = new int[input.length];
    System.arraycopy(input, 0, dup, 0, dup.length);
    Arrays.sort(dup);
    assertEquals(8, solution.longestConsecutive(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int[] input = new int[]{
        -6, 6, -9, -7, 0, 3, 4, -2, 2, -1, 9, -9, 5,
        -3, 6, 1, 5, -1, -2, 9, -9, -4, -6, -5, 6, -1, 3};
    final int[] dup = new int[input.length];
    System.arraycopy(input, 0, dup, 0, dup.length);
    Arrays.sort(dup);
    assertEquals(14, solution.longestConsecutive(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SrcToLengthSolution(),
        new SrcToDstMapSolution()
    );
  }
}