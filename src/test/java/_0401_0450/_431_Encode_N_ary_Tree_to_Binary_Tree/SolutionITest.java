package _0401_0450._431_Encode_N_ary_Tree_to_Binary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.nAryTree.Node;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final Node input = new Node(1, List.of(
        new Node(3, List.of(new Node(5), new Node(6))),
        new Node(2),
        new Node(4)
    )), actual = solution.decode(solution.encode(input));
    assertEquals(input, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}