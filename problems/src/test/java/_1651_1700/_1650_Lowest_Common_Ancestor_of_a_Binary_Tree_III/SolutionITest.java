package _1651_1700._1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III;

import definition._1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final Node node3 = new Node(),
        node5 = new Node(),
        node1 = new Node(),
        node6 = new Node(),
        node2 = new Node(),
        node0 = new Node(),
        node8 = new Node(),
        node7 = new Node(),
        node4 = new Node();
    node3.val = 3;
    node5.val = 5;
    node1.val = 1;
    node6.val = 6;
    node2.val = 2;
    node0.val = 0;
    node8.val = 8;
    node7.val = 7;
    node4.val = 4;
    node3.left = node5;
    node5.parent = node3;

    node3.right = node1;
    node1.parent = node3;

    node5.left = node6;
    node5.right = node2;
    node6.parent = node5;
    node2.parent = node5;

    node2.left = node7;
    node7.parent = node2;
    node2.right = node4;
    node4.parent = node2;

    node1.left = node0;
    node0.parent = node1;
    node1.right = node8;
    node8.parent = node1;

    assertEquals(node3, solution.lowestCommonAncestor(node5, node1));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new TwoRunnerSolution()
    );
  }
}
