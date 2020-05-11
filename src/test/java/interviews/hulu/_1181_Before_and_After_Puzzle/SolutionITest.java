package interviews.hulu._1181_Before_and_After_Puzzle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] phrases = {"writing code", "code rocks"};
    final List<String> output = List.of("writing code rocks");
    assertEquals(output, solution.beforeAndAfterPuzzles(phrases));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] phrases = {"a", "b", "a"};
    final List<String> output = List.of("a");
    assertEquals(output, solution.beforeAndAfterPuzzles(phrases));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] phrases = {
        "mission statement",
        "a quick bite to eat",
        "a chip off the old block",
        "chocolate bar",
        "mission impossible",
        "a man on a mission",
        "block party",
        "eat my words",
        "bar of soap"};
    final List<String> output = List.of(
        "a chip off the old block party",
        "a man on a mission impossible",
        "a man on a mission statement",
        "a quick bite to eat my words",
        "chocolate bar of soap");
    assertEquals(output, solution.beforeAndAfterPuzzles(phrases));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}