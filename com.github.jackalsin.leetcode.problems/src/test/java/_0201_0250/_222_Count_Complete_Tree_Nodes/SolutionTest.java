package _0201_0250._222_Count_Complete_Tree_Nodes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/15/2017.
 */
public class SolutionTest {

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

  @Test
  public void testHeight() {
    TreeNode root4 = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7, 8, 9);
    assertEquals(4, SolutionI.height(root4));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}
