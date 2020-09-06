package _0801_0850._848_Shifting_Letters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "abc";
    final int[] shifts = {3, 5, 9};
    assertEquals("rpl", solution.shiftingLetters(s, shifts));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}