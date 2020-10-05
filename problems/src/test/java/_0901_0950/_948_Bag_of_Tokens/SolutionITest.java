package _0901_0950._948_Bag_of_Tokens;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/26/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int tokens[] = {100}, P = 50;
    assertEquals(0, solution.bagOfTokensScore(tokens, P));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int tokens[] = {100, 200}, P = 150;
    assertEquals(1, solution.bagOfTokensScore(tokens, P));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int tokens[] = {100, 200, 300, 400}, P = 200;
    assertEquals(2, solution.bagOfTokensScore(tokens, P));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int tokens[] = {26}, P = 56;
    assertEquals(1, solution.bagOfTokensScore(tokens, P));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int tokens[] = {25, 91}, P = 99;
    assertEquals(1, solution.bagOfTokensScore(tokens, P));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final int tokens[] = {43, 61, 92}, P = 97;
    assertEquals(1, solution.bagOfTokensScore(tokens, P));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}