package _0401_0450._429_N_ary_Tree_Level_Order_Traversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition.nAryTree.Node;

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
    final Node root = new Node(1, List.of(
        new Node(3), new Node(2), new Node(4)
    ));
    root.children.get(0).children = List.of(new Node(5), new Node(6));
    final List<List<Integer>> expected = List.of(
        List.of(1),
        List.of(3, 2, 4),
        List.of(5, 6)
    ), actual = solution.levelOrder(root);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}