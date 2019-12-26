package _0501_0550._510_Inorder_Successor_in_BST_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._510_Inorder_Successor_in_BST_II.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static utils._510_Inorder_Successor_in_BST_II.Nodes.link;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final Node node1 = new Node(), node2 = new Node(), node3 = new Node();
    node1.val = 1;
    node2.val = 2;
    node3.val = 3;
    link(node2, node1, node3);
    final Node actual = solution.inorderSuccessor(node1);
    assertEquals(node2, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final Map<Integer, Node> map = new HashMap<>();
    for (int val : new int[]{1, 2, 3, 4, 5, 6, 7, 8}) {
      final Node root = new Node();
      map.put(val, root);
      root.val = val;
    }
    link(map.get(5), map.get(3), map.get(6));
    link(map.get(3), map.get(2), map.get(4));
    link(map.get(2), map.get(1), null);
    final Node actual = solution.inorderSuccessor(map.get(6));
    assertNull(actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
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
    final Node actual = solution.inorderSuccessor(map.get(15));
    assertEquals(map.get(17), actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}