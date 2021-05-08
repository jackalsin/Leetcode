package google.majiang;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/7/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<Integer> tiles = List.of(4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8);
    assertTrue(solution.canWin(tiles));
  }

  // 3AAA ABC DD
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<Integer> tiles = List.of(4, 4, 4, 5, 5, 5, 6, 6, 6, 5, 6, 7, 8, 8);
    assertTrue(solution.canWin(tiles));
  }

  // 2AAA 2ABC, DD
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final List<Integer> tiles = List.of(3, 4, 5,
        4, 4, 4,
        5, 5, 5,
        6, 7, 8,
        8, 8);
    assertTrue(solution.canWin(tiles));
  }

  // AAA + 3 ABC + DD
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final List<Integer> tiles = List.of(4, 4, 4,
        5, 6, 7,
        5, 6, 7,
        6, 7, 8,
        8, 8);
    assertTrue(solution.canWin(tiles));
  }

  // AAA + 3 ABC + DD
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final List<Integer> tiles = List.of(
        3, 4, 5,
        5, 6, 7,
        5, 6, 7,
        6, 7, 8,
        8, 8);
    assertTrue(solution.canWin(tiles));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseFailed(Solution solution) {
    final List<Integer> tiles = List.of(4, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9);
    assertFalse(solution.canWin(tiles));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}