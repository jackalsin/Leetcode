package interviews.microsoft._173_Binary_Search_Tree_Iterator;

import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.*;

class BSTIteratorTest {

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    BSTIterator iterator = new BSTIterator(root);

    assertTrue(iterator.hasNext());
    assertEquals(1, iterator.next());

    assertTrue(iterator.hasNext());
    assertEquals(2, iterator.next());

    assertTrue(iterator.hasNext());
    assertEquals(3, iterator.next());

    assertTrue(iterator.hasNext());
    assertEquals(4, iterator.next());

    assertTrue(iterator.hasNext());
    assertEquals(5, iterator.next());

    assertTrue(iterator.hasNext());
    assertEquals(6, iterator.next());

    assertTrue(iterator.hasNext());
    assertEquals(7, iterator.next());
    assertFalse(iterator.hasNext());

  }
}