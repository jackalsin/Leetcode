package _0551_0600._590_N_ary_Tree_Postorder_Traversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.treeNode.Node;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final Node three = new Node(3, List.of(
        new Node(5, null),
        new Node(6, null))),
        two = new Node(2, null),
        four = new Node(4, null);
    final Node root = new Node(1, List.of(
        three, two, four
    ));
    final List<Integer> expected = List.of(5, 6, 3, 2, 4, 1),
        actual = solution.postorder(root);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}