package interviews.linkedin._245_Shortest_Word_Distance_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(1, solution.shortestWordDistance(words, "makes", "coding"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(3, solution.shortestWordDistance(words, "makes", "makes"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI()
    );
  }
}