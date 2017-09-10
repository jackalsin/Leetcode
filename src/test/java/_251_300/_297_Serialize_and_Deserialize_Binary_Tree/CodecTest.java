package _251_300._297_Serialize_and_Deserialize_Binary_Tree;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class CodecTest {
  private Codec solution;
  @Before
  public void setUp() throws Exception {
    solution = new Codec();
  }

  @Test
  public void testCase1() throws Exception {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }
}
