package _0601_0650._625_Minimum_Factorization;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 3/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertEquals(68, solution.smallestFactorization(48));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    assertEquals(35, solution.smallestFactorization(15));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    assertEquals(1, solution.smallestFactorization(1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    assertEquals(0, solution.smallestFactorization(18000000));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionII(),
        new SolutionI()
    );
  }
}