package interviews.linkedin._151_Reverse_Words_in_a_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline(Solution solution) {
    String input = "the sky is blue";
    String expected = "blue is sky the";
    assertEquals(expected, solution.reverseWords(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testSpace(Solution solution) {
    String input = " ";
    String expected = "";
    assertEquals(expected, solution.reverseWords(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed(Solution solution) {
    String input = " 1";
    String expected = "1";
    assertEquals(expected, solution.reverseWords(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed2(Solution solution) {
    String input = "1 ";
    String expected = "1";
    assertEquals(expected, solution.reverseWords(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV()
    );
  }
}