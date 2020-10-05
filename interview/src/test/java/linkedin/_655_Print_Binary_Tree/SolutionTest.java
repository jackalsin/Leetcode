package linkedin._655_Print_Binary_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/26/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, null);
    final List<List<String>> expected = List.of(
        List.of("", "1", ""),
        List.of("2", "", "")
    );
    final List<List<String>> actual = solution.printTree(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, null, 4);
    final List<List<String>> expected = List.of(
        List.of("", "", "", "1", "", "", ""),
        List.of("", "2", "", "", "", "3", ""),
        List.of("", "", "4", "", "", "", "")
    );
    final List<List<String>> actual = solution.printTree(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 5, 3);
    input.left.left.left = new TreeNode(4);
    final List<List<String>> expected = List.of(
        List.of("", "", "", "", "", "", "", "1", "", "", "", "", "", "", ""),
        List.of("", "", "", "2", "", "", "", "", "", "", "", "5", "", "", ""),
        List.of("", "3", "", "", "", "", "", "", "", "", "", "", "", "", ""),
        List.of("4", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
    );
    final List<List<String>> actual = solution.printTree(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}