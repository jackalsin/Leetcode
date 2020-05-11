package _0551_0600._559_Maximum_Depth_of_N_ary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._559_Maximum_Depth_of_N_ary_Tree.Node;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    // Input: root = [1,null,3,2,4,null,5,6]
    final Node root = new Node(1);
    final Node node3 = new Node(3);
    node3.children = List.of(new Node(5), new Node(6));
    root.children = List.of(node3, new Node(2), new Node(4));
    assertEquals(3, solution.maxDepth(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}