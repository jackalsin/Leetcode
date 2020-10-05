package _0451_0500._488_Zuma_Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String board = "WRRBBW", hand = "RB";
    assertEquals(-1, solution.findMinStep(board, hand));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String board = "WWRRBBWW", hand = "WRBRW";
    assertEquals(2, solution.findMinStep(board, hand));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String board = "G", hand = "GGGGG";
    assertEquals(2, solution.findMinStep(board, hand));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String board = "RBYYBBRRB", hand = "YRBGB";
    assertEquals(3, solution.findMinStep(board, hand));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String board = "RRWWRRBBRR", hand = "WB";
    assertEquals(2, solution.findMinStep(board, hand));
  }

  // ----------------------- test find min step -------------------------------------
  // test RemoveContinuous
  @Test
  void testRemoveContinuous() {
    final String board = "WWWW", hand = "WW";
    assertEquals("", SolutionI.removeContinuous(board));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}