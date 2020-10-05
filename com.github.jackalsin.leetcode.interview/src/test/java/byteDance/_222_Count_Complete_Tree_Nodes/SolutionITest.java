package byteDance._222_Count_Complete_Tree_Nodes;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOneElement(Solution solution) {
    assertEquals(1, solution.countNodes(new TreeNode(1)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test4Levels(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
    assertEquals(13, solution.countNodes(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}