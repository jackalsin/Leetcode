package interviews.linkedin._748_Shortest_Completing_Word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String licensePlate = "1s3 PSt", expected = "steps";
    final String[] words = {"step", "steps", "stripe", "stepple"};
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String licensePlate = "1s3 456", expected = "pest";
    final String[] words = {"looks", "pest", "stew", "show"};
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String licensePlate = "GrC8950", expected = "according";
    final String[] words = {
        "measure", "other", "every", "base", "according", "level", "meeting", "none", "marriage", "rest"
    };
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }
}