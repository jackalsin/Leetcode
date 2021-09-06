package airbnb._864_Shortest_Path_to_Get_All_Keys;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/5/2021
 */
class SolutionITest {

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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] input = {
        "@...a",
        ".###A",
        "b.BCc"
    };
    assertEquals(10, solution.shortestPathAllKeys(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}