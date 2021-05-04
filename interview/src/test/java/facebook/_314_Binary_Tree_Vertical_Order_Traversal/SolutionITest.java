package facebook._314_Binary_Tree_Vertical_Order_Traversal;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/3/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testExample1(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 20, null, null, 15, 7);
    final List<List<Integer>> expected = List.of(
        List.of(9),
        List.of(3, 15),
        List.of(20),
        List.of(7)
    );
    assertEquals(expected, solution.verticalOrder(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testExample2(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 8, 4, 0, 1, 7);
    final List<List<Integer>> expected = List.of(
        List.of(4),
        List.of(9),
        List.of(3, 0, 1),
        List.of(8),
        List.of(7)
    );
    assertEquals(expected, solution.verticalOrder(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testExample3(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5);
    final List<List<Integer>> expected = List.of(
        List.of(4),
        List.of(9, 5),
        List.of(3, 0, 1),
        List.of(8, 2),
        List.of(7)
    );
    assertEquals(expected, solution.verticalOrder(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testNull(Solution solution) {
    assertEquals(new ArrayList<>(), solution.verticalOrder(null));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}