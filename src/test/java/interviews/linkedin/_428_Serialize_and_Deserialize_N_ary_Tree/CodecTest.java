package interviews.linkedin._428_Serialize_and_Deserialize_N_ary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.treeNode.Node;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
class CodecTest {

  private Codec solution;

  @BeforeEach
  void setup() {
    solution = new Codec();
  }

  @Test
  void testOnlineCase1() {
    final Node root = new Node();
    root.val = 1;
    root.children = List.of(new Node(3, List.of(
        new Node(5, List.of()), new Node(6, List.of())
    )), new Node(2, List.of()), new Node(4, List.of()));
    final String actual = solution.serialize(root);
    assertEquals(root, solution.deserialize(actual));
  }

  @Test
  void testOnlineCase2() {
    final Node root = new Node();
    root.val = 1;
    root.children = List.of(new Node(3, List.of(
        new Node(5, List.of(new Node(6, List.of())))
    )), new Node(2, List.of()), new Node(4, List.of()));
    final String actual = solution.serialize(root);
    assertEquals(root, solution.deserialize(actual));
  }

  @Test
  void testNull() {
    final Node root = null;
    final String actual = solution.serialize(root);
    assertEquals(root, solution.deserialize(actual));
  }
}