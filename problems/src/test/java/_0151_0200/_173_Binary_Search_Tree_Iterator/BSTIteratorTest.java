package _0151_0200._173_Binary_Search_Tree_Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/31/2017.
 */
class BSTIteratorTest {
  private BSTIterator bstIterator;

  @BeforeEach
  void setUp() {
    bstIterator = null;
  }

  @Test
  void testOneElement() {
    TreeNode root = TreeNodes.getTreeLevelOrder(1);
    bstIterator = new BSTIterator(root);
    assertEquals(1, bstIterator.next());
  }

  @Test
  void testTwoElements() {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    bstIterator = new BSTIterator(root);
    assertEquals(2, bstIterator.next());
    assertEquals(1, bstIterator.next());
    assertEquals(3, bstIterator.next());
  }

}
