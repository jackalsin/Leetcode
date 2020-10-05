package _0801_0850._816_Ambiguous_Coordinates;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final Set<String> expected = Set.of(
        "(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"
    );
    final String s = "(123)";
    final List<String> actual = solution.ambiguousCoordinates(s);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final Set<String> expected = Set.of(
        "(0.001, 1)", "(0, 0.011)"
    );
    final String s = "(00011)";
    final List<String> actual = solution.ambiguousCoordinates(s);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final Set<String> expected = Set.of(
        "(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"
    );
    final String s = "(0123)";
    final List<String> actual = solution.ambiguousCoordinates(s);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final Set<String> expected = Set.of(
        "(10, 0)"
    );
    final String s = "(100)";
    final List<String> actual = solution.ambiguousCoordinates(s);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}