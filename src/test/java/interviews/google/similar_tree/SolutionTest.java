package interviews.google.similar_tree;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/27/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new ONSquareSolution();
    solution = new ONSolution();
  }

  @Test
  public void test2LevelTheSame() throws Exception {
    final TreeNode root1 = TreeNodes.getTreeLevelOrder(2, 1, 3);
    final TreeNode root2 = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertTrue(solution.isSimilarTree(root1, root2));
  }

  @Test
  public void test2LevleSimilar() throws Exception {
    final TreeNode root1 = TreeNodes.getTreeLevelOrder(2, 3, 1);
    final TreeNode root2 = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertTrue(solution.isSimilarTree(root1, root2));
  }

  @Test
  public void test3LevleSimilar() throws Exception {
    final TreeNode root1 = TreeNodes.getTreeLevelOrder(2, 3, 1, null, 8, 7, 5);
    final TreeNode root2 = TreeNodes.getTreeLevelOrder(2, 1, 3, 5, 7, 8);
    assertTrue(solution.isSimilarTree(root1, root2));
  }
}
