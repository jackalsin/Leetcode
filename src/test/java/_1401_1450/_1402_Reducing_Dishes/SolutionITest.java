package _1401_1450._1402_Reducing_Dishes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/23/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int input[] = {-1, -8, 0, 5, -9}, expected = 14;
    assertEquals(expected, solution.maxSatisfaction(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int input[] = {4, 3, 2}, expected = 20;
    assertEquals(expected, solution.maxSatisfaction(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int input[] = {-1, -4, -5}, expected = 0;
    assertEquals(expected, solution.maxSatisfaction(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int input[] = {-2, 5, -1, 0, 3, -3}, expected = 35;
    assertEquals(expected, solution.maxSatisfaction(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}