package interviews.tableau._243_Shortest_Word_Distance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] input = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(3, solution.shortestDistance(input, "coding", "practice"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] input = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(1, solution.shortestDistance(input, "makes", "coding"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}