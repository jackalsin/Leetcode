package _0851_0900._864_Shortest_Path_to_Get_All_Key;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new BfsSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] input = {
        "@.a.#",
        "###.#",
        "b.A.B"
    };
    assertEquals(8, solution.shortestPathAllKeys(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] input = {
        "@..aA",
        "..B#.",
        "....b"
    };
    assertEquals(6, solution.shortestPathAllKeys(input));
  }
}