package _151_200._173_Binary_Search_Tree_Iterator;

import org.junit.Before;
import org.junit.Test;

import _151_200._191_Number_of_1_Bits.Solution;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/31/2017.
 */
public class BSTIteratorTest {
  private BSTIterator bstIterator;
  @Before
  public void setUp() throws Exception {
    bstIterator = null;
  }

  @Test
  public void testOneElement() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1);
    bstIterator = new BSTIterator(root);
    assertEquals(1, bstIterator.next());
  }

  @Test
  public void testTwoElements() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    bstIterator = new BSTIterator(root);
    assertEquals(2, bstIterator.next());
    assertEquals(1, bstIterator.next());
    assertEquals(3, bstIterator.next());
  }

}
