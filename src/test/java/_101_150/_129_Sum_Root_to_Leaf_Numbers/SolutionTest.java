package _101_150._129_Sum_Root_to_Leaf_Numbers;

import com.sun.org.apache.xpath.internal.CachedXPathAPI;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testNull() throws Exception {
    assertEquals(0, solution.sumNumbers(null));
  }

  @Test
  public void test123Balanced() throws Exception {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(25, solution.sumNumbers(input));
  }

  @Test
  public void test13LeftEmpty() throws Exception {
    TreeNode root = new TreeNode(1);
      root.right = new TreeNode(3);
    assertEquals(13, solution.sumNumbers(root));
  }
}