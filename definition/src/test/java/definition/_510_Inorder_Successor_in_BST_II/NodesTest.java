package definition._510_Inorder_Successor_in_BST_II;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static definition._510_Inorder_Successor_in_BST_II.Nodes.link;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
class NodesTest {

  @Test
  void testOnlineCase1() {
    final Node actual = Nodes.getByLevelOrder(
        2,
        1, 3
    );
    final Node expected = new Node(),
        left = new Node(), right = new Node();
    expected.val = 2;
    left.val = 1;
    right.val = 3;
    link(expected, left, right);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final Node actual = Nodes.getByLevelOrder(
        5,
        3, 6,
        2, 4, null, null,
        1
    );
    final Node expected = new Node(),
        node1 = new Node(), node2 = new Node(),
        node3 = new Node(), node4 = new Node(),
        node6 = new Node();
    node1.val = 1;
    node2.val = 2;
    node3.val = 3;
    node4.val = 4;
    expected.val = 5;
    node6.val = 6;
    link(expected, node3, node6);
    link(node3, node2, node4);
    link(node2, node1, null);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase3() {
    final Node actual = Nodes.getByLevelOrder(
        15,
        6, 18,
        3, 7, 17, 20,
        2, 4, null, 13, null, null, null, null,
        null, null, null, null, 9
    );
    final Map<Integer, Node> map = new HashMap<>();
    for (int i : new int[]{2, 3, 4, 6, 7, 9, 13, 15, 17, 18, 20}) {
      final Node node = new Node();
      node.val = i;
      map.put(i, node);
    }
    link(map.get(15), map.get(6), map.get(18));
    link(map.get(6), map.get(3), map.get(7));
    link(map.get(3), map.get(2), map.get(4));
    link(map.get(7), null, map.get(13));
    link(map.get(18), map.get(17), map.get(20));
    link(map.get(13), map.get(9), null);
    assertEquals(map.get(15), actual);
  }

}