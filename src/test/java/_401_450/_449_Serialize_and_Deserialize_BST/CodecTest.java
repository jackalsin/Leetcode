package _401_450._449_Serialize_and_Deserialize_BST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodecTest {
  private Codec solution;

  @BeforeEach
  void setUp() {
    solution = new Codec();
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