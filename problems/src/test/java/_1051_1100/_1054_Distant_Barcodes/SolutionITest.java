package _1051_1100._1054_Distant_Barcodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static assertions._1054_Distant_Barcodes.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/31/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 1, 1, 2, 2, 2},
        expected = {1, 2, 1, 2, 1, 2}, actual = solution.rearrangeBarcodes(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1, 1, 1, 1, 2, 2, 3, 3},
        expected = {1, 3, 1, 3, 2, 1, 2, 1}, actual = solution.rearrangeBarcodes(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] input = {1},
        expected = {1}, actual = solution.rearrangeBarcodes(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int[] input = {7, 7, 7, 8, 5, 7, 5, 5, 5, 8},
        expected = {7, 7, 7, 8, 5, 7, 5, 5, 5, 8}, actual = solution.rearrangeBarcodes(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}