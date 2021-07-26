package doordash.findDifference;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final Node root1 = new Node(
        "a", 4, List.of(
        new Node("b", 1, List.of(
            new Node("d", 3),
            new Node("e", 5),
            new Node("f", 5)
        )),
        new Node("c", 5, List.of(
            new Node("g", 12)))
    )), root2 = new Node(
        "a", 4, List.of(
        new Node("b", 1, List.of(
            new Node("e", 5),
            new Node("d", 3),
            new Node("w", 8)
        )),
        new Node("m", 5, List.of(
            new Node("g", 12)))
    ));
    final int expected = 6,
        actual = solution.findDiff(root1, root2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
