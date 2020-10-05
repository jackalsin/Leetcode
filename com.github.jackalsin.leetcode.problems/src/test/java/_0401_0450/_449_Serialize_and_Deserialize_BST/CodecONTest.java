package _0401_0450._449_Serialize_and_Deserialize_BST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
class CodecONTest {
  private CodecON solution;

  @BeforeEach
  void setUp() {
    solution = new CodecON();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, null, 3);
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  @Test
  void testFailedCase1() {
    final TreeNode root = null;
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }
}