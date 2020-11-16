package _1051_1100._1059_All_Paths_from_Source_Lead_to_Destination;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int n = 3, edges[][] = {{0, 1}, {0, 2}}, source = 0, destination = 2;
    assertFalse(solution.leadsToDestination(n, edges, source, destination));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int n = 4, edges[][] = {{0, 1}, {0, 3}, {1, 2}, {2, 1}}, source = 0, destination = 3;
    assertFalse(solution.leadsToDestination(n, edges, source, destination));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int n = 4, edges[][] = {{0, 1}, {0, 2}, {1, 3}, {2, 3}}, source = 0, destination = 3;
    assertTrue(solution.leadsToDestination(n, edges, source, destination));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int n = 3, edges[][] = {{0, 1}, {1, 1}, {1, 2}}, source = 0, destination = 2;
    assertFalse(solution.leadsToDestination(n, edges, source, destination));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}