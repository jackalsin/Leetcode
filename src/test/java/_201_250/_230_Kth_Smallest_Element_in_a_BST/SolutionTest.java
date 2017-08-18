package _201_250._230_Kth_Smallest_Element_in_a_BST;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOne() {
    TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(1, solution.kthSmallest(root, 1));
  }

  @Test
  public void test4Level() {
    TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    for (int i = 1; i <= 7; i++) {
      System.out.print("k = " + i);
      assertEquals("k = " + i + " pass", i, solution.kthSmallest(root, i));
      System.out.println(" pass");
    }
  }

}
