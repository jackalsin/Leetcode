package _0651_0700._675_Cut_Off_Trees_for_Golf_Event;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 3),
        List.of(0, 0, 4),
        List.of(7, 6, 5)
    );
    assertEquals(6, solution.cutOffTree(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 3),
        List.of(0, 0, 0),
        List.of(7, 6, 5)
    );
    assertEquals(-1, solution.cutOffTree(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(2, 3, 4),
        List.of(0, 0, 5),
        List.of(8, 7, 6)
    );
    assertEquals(6, solution.cutOffTree(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(54581641, 64080174, 24346381, 69107959),
        List.of(86374198, 61363882, 68783324, 79706116),
        List.of(668150, 92178815, 89819108, 94701471),
        List.of(83920491, 22724204, 46281641, 47531096),
        List.of(89078499, 18904913, 25462145, 60813308)
    );
    assertEquals(57, solution.cutOffTree(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(8, 11, 4, 13),
        List.of(16, 10, 12, 14),
        List.of(1, 19, 18, 20),
        List.of(15, 3, 6, 7),
        List.of(17, 2, 5, 9)
    );
    assertEquals(57, solution.cutOffTree(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}