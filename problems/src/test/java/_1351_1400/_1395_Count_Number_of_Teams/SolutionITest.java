package _1351_1400._1395_Count_Number_of_Teams;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int rating[] = {2, 5, 3, 4, 1}, expected = 3;
    assertEquals(expected, solution.numTeams(rating));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int rating[] = {2, 1, 3}, expected = 0;
    assertEquals(expected, solution.numTeams(rating));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int rating[] = {1, 2, 3, 4}, expected = 4;
    assertEquals(expected, solution.numTeams(rating));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}