package microsoft._173_Binary_Search_Tree_Iterator;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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