package interviews.tableau._488_Zuma_Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/18/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String board = "WRRBBW", hand = "RB";
    assertEquals(-1, solution.findMinStep(board, hand));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String board = "WWRRBBWW", hand = "WRBRW";
    assertEquals(2, solution.findMinStep(board, hand));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String board = "G", hand = "GGGGG";
    assertEquals(2, solution.findMinStep(board, hand));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String board = "RBYYBBRRB", hand = "YRBGB";
    assertEquals(3, solution.findMinStep(board, hand));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final String board = "RRWWRRBBRR", hand = "WB";
    assertEquals(2, solution.findMinStep(board, hand));
  }

  @Test
  void testRemoveContinuously() {
    assertEquals("", SolutionI.removeContinuously("WWWW"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}