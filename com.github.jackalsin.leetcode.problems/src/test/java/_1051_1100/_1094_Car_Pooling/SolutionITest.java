package _1051_1100._1094_Car_Pooling;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhixi
 * @version 1.0 on 9/21/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int trips[][] = {{2, 1, 5}, {3, 3, 7}}, capacity = 4;
    assertFalse(solution.carPooling(trips, capacity));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int trips[][] = {{2, 1, 5}, {3, 3, 7}}, capacity = 5;
    assertTrue(solution.carPooling(trips, capacity));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int trips[][] = {{2, 1, 5}, {3, 5, 7}}, capacity = 3;
    assertTrue(solution.carPooling(trips, capacity));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int trips[][] = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, capacity = 11;
    assertTrue(solution.carPooling(trips, capacity));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}