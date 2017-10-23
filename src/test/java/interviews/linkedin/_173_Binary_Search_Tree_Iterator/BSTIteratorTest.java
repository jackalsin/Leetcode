package interviews.linkedin._173_Binary_Search_Tree_Iterator;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public class BSTIteratorTest {
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test1Null2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 2);
    BSTIterator bstIterator = new BSTIterator(root);
    assertEquals(1, bstIterator.next());
    assertEquals(2, bstIterator.next());
  }

  @Test
  public void test1To15() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11,
        13, 15);
    BSTIterator bstIterator = new BSTIterator(root);
    assertEquals(1, bstIterator.next());
    assertEquals(2, bstIterator.next());
    assertEquals(3, bstIterator.next());
    assertEquals(4, bstIterator.next());
    assertEquals(5, bstIterator.next());
    assertEquals(6, bstIterator.next());
    assertEquals(7, bstIterator.next());
    assertEquals(8, bstIterator.next());
    assertEquals(9, bstIterator.next());
    assertEquals(10, bstIterator.next());
    assertEquals(11, bstIterator.next());
    assertEquals(12, bstIterator.next());
    assertEquals(13, bstIterator.next());
    assertEquals(14, bstIterator.next());
    assertEquals(15, bstIterator.next());
  }
}
