package _1351_1400._1388_Pizza_With_3n_Slices;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/22/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 4, 5, 6};
    assertEquals(10, solution.maxSizeSlices(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] input = new int[]{8, 9, 8, 6, 1, 1};
    assertEquals(16, solution.maxSizeSlices(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] input = new int[]{4, 1, 2, 5, 8, 3, 1, 9, 7};
    assertEquals(21, solution.maxSizeSlices(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int[] input = new int[]{3, 1, 2};
    assertEquals(3, solution.maxSizeSlices(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCaseTLE(Solution solution) {
    final int[] input = new int[]{3, 9, 4, 5, 3, 8, 1, 10, 3, 7, 2, 9, 10, 2, 6, 2, 9, 8, 7, 10, 7, 5, 1, 6, 5, 8, 9,
        10, 6, 5, 7, 7, 2, 5, 3, 10, 4, 3, 4};
    assertEquals(110, solution.maxSizeSlices(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionII()
    );
  }
}