package google.leafSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/12/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final Node node1 = new Node(1),
        node2 = new Node(2),
        node3 = new Node(3),
        node4 = new Node(4),
        node5 = new Node(5),
        node6 = new Node(6),
        node7 = new Node(7);
    node4.children.add(node2);
    node2.parent = node4;
    node4.children.add(node6);
    node6.parent = node4;
    node2.children.add(node1);
    node1.parent = node2;
    node2.children.add(node3);
    node3.parent = node2;
    node6.children.add(node5);
    node5.parent = node6;
    node6.children.add(node7);
    node7.parent = node6;
    assertEquals(1 + 3 + 5 + 7, solution.leafOfSum(node4));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}