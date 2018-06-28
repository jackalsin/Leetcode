package interviews.linkedin._297_Serialize_and_Deserialize_Binary_Tree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public class CodecTest {
  Codec codec;

  @Before
  public void setUp() throws Exception {
    codec = new CodecII();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    System.out.println(codec.serialize(root));
    assertEquals(root, codec.deserialize(codec.serialize(root)));
  }
}
