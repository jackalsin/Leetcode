package interviews.facebook._173_Binary_Search_Tree_Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

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