package uber._297_Serialize_and_Deserialize_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodecTest {
  private Codec solution;

  @BeforeEach
  void setUp() {
    solution = new Codec();
  }

  @Test
  void testCase1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }
}