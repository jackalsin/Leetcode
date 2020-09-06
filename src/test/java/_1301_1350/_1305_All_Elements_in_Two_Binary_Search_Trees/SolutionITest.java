package _1301_1350._1305_All_Elements_in_Two_Binary_Search_Trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root1 = TreeNodes.getTreeLevelOrder(2, 1, 4),
        root2 = TreeNodes.getTreeLevelOrder(1, 0, 3);
    final List<Integer> expected = List.of(0, 1, 1, 2, 3, 4),
        actual = solution.getAllElements(root1, root2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}