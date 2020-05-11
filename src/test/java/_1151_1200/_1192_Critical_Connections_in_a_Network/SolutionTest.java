package _1151_1200._1192_Critical_Connections_in_a_Network;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int n = 4;
    final List<List<Integer>> connections = List.of(
        List.of(0, 1),
        List.of(1, 2),
        List.of(2, 0),
        List.of(1, 3)),
        expected = List.of(List.of(1, 3)), actual = solution.criticalConnections(n, connections);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}