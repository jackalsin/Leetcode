package interviews.oracle._116_Populating_Next_Right_Pointers_in_Each_Node;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.treeLinkNode._116_Populating_Next_Right_Pointers_in_Each_Node.Node;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    Node expected = new Node();
    expected.val = 1;
    expected.left = new Node();
    expected.left.val = 2;
    expected.right = new Node();
    expected.right.val = 3;
    expected.left.next = expected.right;

    expected.left.left = new Node();
    expected.left.left.val = 4;
    expected.left.right = new Node();
    expected.left.right.val = 5;
    expected.right.left = new Node();
    expected.right.left.val = 6;
    expected.right.right = new Node();
    expected.right.right.val = 7;

    expected.left.left.next = expected.left.right;
    expected.left.right.next = expected.right.left;
    expected.right.left.next = expected.right.right;

    Node root = new Node();
    root.val = 1;
    root.left = new Node();
    root.left.val = 2;
    root.right = new Node();
    root.right.val = 3;

    root.left.left = new Node();
    root.left.left.val = 4;
    root.left.right = new Node();
    root.left.right.val = 5;
    root.right.left = new Node();
    root.right.left.val = 6;
    root.right.right = new Node();
    root.right.right.val = 7;
    solution.connect(root);

    assertEquals(expected, root);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}