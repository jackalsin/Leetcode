package _1001_1050._1037_Valid_Boomerang;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhixi
 * @version 1.0 on 10/23/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {{1, 1}, {2, 3}, {3, 2}};
    assertTrue(solution.isBoomerang(input));

  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {{1, 1}, {2, 2}, {3, 3}};
    assertFalse(solution.isBoomerang(input));
  }  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {{0, 0}, {1, 1}, {1, 1}};
    assertFalse(solution.isBoomerang(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}