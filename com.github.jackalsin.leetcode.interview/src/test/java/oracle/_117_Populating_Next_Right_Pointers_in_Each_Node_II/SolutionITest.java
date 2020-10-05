package oracle._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import definition.treeLinkNode._117_Populating_Next_Right_Pointers_in_Each_Node_II.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFullBalancedTree(Solution solution) {
    Node expected = new Node(1);
    expected.left = new Node(2);
    expected.right = new Node(3);
    expected.left.next = expected.right;

    expected.left.left = new Node(4);
    expected.left.right = new Node(5);
    expected.right.left = new Node(6);
    expected.right.right = new Node(7);

    expected.left.left.next = expected.left.right;
    expected.left.right.next = expected.right.left;
    expected.right.left.next = expected.right.right;

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    solution.connect(root);

    assertEquals(expected, root);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNullInMid(Solution solution) {
    Node expected = new Node(1);
    expected.left = new Node(2);
    expected.right = new Node(3);
    expected.left.next = expected.right;

    expected.left.left = new Node(4);
    expected.right.left = new Node(6);
    expected.right.right = new Node(7);

    expected.left.left.next = expected.right.left;
    expected.right.left.next = expected.right.right;

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    solution.connect(root);

    assertEquals(expected, root);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNullInHead(Solution solution) {
    Node expected = new Node(1);
    expected.left = new Node(2);
    expected.right = new Node(3);
    expected.left.next = expected.right;

    expected.left.right = new Node(5);
    expected.right.left = new Node(6);
    expected.right.right = new Node(7);

    expected.left.right.next = expected.right.left;
    expected.right.left.next = expected.right.right;

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    solution.connect(root);

    assertEquals(expected, root);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new QueueSolution(),
        new O1SpaceSolution()
    );
  }
}