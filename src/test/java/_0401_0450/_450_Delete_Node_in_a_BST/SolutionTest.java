package _0401_0450._450_Delete_Node_in_a_BST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/4/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new NaiveSolution();
    solution = new BetterSolution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(5, 3, 6, 2, 4, null, 7);
    final TreeNode actual = solution.deleteNode(root, 3);
    System.out.println(actual);
    Set<TreeNode> expected = Set.of(
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(5, 4, 6, 2, null, null, 7)),
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(5, 2, 6, null, 4, null, 7))
    );
    assertTrue(expected.contains(actual));
  }
}
