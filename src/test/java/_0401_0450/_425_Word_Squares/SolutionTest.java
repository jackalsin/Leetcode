package _0401_0450._425_Word_Squares;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] words = {"area", "lead", "wall", "lady", "ball"};
    final List<List<String>> expected = List.of(
        List.of(
            "wall",
            "area",
            "lead",
            "lady"),
        List.of(
            "ball",
            "area",
            "lead",
            "lady"
        )
    );
    final List<List<String>> actual = solution.wordSquares(words);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] words = {"abat", "baba", "atan", "atal"};
    final List<List<String>> expected = List.of(
        List.of(
            "baba",
            "abat",
            "baba",
            "atan"
        ),
        List.of(
            "baba",
            "abat",
            "baba",
            "atal"
        )
    );
    final List<List<String>> actual = solution.wordSquares(words);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionII(),
        new SolutionI()
    );
  }

}