package _0951_1000._1000_Minimum_Cost_to_Merge_Stones;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/16/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int stones[] = {3, 2, 4, 1}, K = 2, expected = 20;
    assertEquals(expected, solution.mergeStones(stones, K));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int stones[] = {3, 2, 4, 1}, K = 3, expected = -1;
    assertEquals(expected, solution.mergeStones(stones, K));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int stones[] = {3, 5, 1, 2, 6}, K = 3, expected = 25;
    assertEquals(expected, solution.mergeStones(stones, K));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int stones[] = {1}, K = 2, expected = 0;
    assertEquals(expected, solution.mergeStones(stones, K));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}