package _0851_0900._881_Boats_to_Save_People;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int people[] = {1, 2}, limit = 3, expected = 1,
        actual = solution.numRescueBoats(people, limit);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int people[] = {3, 2, 3, 2, 2}, limit = 6, expected = 3,
        actual = solution.numRescueBoats(people, limit);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int people[] = {3, 2, 2, 1}, limit = 3, expected = 3,
        actual = solution.numRescueBoats(people, limit);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int people[] = {3, 5, 3, 4}, limit = 5, expected = 4,
        actual = solution.numRescueBoats(people, limit);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}