package _1901_1950._1921_Eliminate_Maximum_Number_of_Monsters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/3/2021
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] dist = {1, 3, 4}, speed = {1, 1, 1};
    assertEquals(3, solution.eliminateMaximum(dist, speed));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] dist = {1, 1, 2, 3}, speed = {1,1,1,1};
    assertEquals(1, solution.eliminateMaximum(dist, speed));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] dist = {3, 2, 4}, speed = {5, 3,2};
    assertEquals(1, solution.eliminateMaximum(dist, speed));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}