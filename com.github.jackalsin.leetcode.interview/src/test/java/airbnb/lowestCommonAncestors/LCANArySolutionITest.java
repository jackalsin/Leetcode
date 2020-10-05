package airbnb.lowestCommonAncestors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.nAryTree.Node;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LCANArySolutionITest {
  private LCANAryTree solution;
  private static final Node root = new Node(9,
      List.of(
          new Node(1, List.of(
              new Node(2, List.of(
                  new Node(4, new ArrayList<>()),
                  new Node(5, new ArrayList<>())
              )),
              new Node(3, new ArrayList<>()),
              new Node(6, List.of(
                  new Node(7, new ArrayList<>()),
                  new Node(8, new ArrayList<>())
              ))
          ))
      ));

  @BeforeEach
  void setup() {
    solution = new LCANArySolutionI();
  }

  @Test
  void testFrom2parent() {
    final Node node4 = root.children.get(0).children.get(0).children.get(0),
        node7 = root.children.get(0).children.get(2).children.get(0),
        node1 = root.children.get(0);
    assertEquals(node1, solution.getLowestCommonAncestor(root, node7, node4));
  }

  @Test
  void testOneIsParent() {
    final Node node4 = root.children.get(0).children.get(0).children.get(0),
        node2 = root.children.get(0).children.get(0);
    assertEquals(node2, solution.getLowestCommonAncestor(root, node2, node4));
  }

  @Test
  void testOneIsParentSymmetric() {
    final Node node4 = root.children.get(0).children.get(0).children.get(0),
        node2 = root.children.get(0).children.get(0);
    assertEquals(node2, solution.getLowestCommonAncestor(root, node4, node2));
  }

  @Test
  void testBothNull() {
    assertThrows(NullPointerException.class, () -> solution.getLowestCommonAncestor(root, null, null));
  }

  @Test
  void testOneIsNull() {
    final Node node4 = root.children.get(0).children.get(0).children.get(0);
    assertThrows(NullPointerException.class,
        () -> assertEquals(node4, solution.getLowestCommonAncestor(root, node4, null))
    );
  }

  @Test
  void testOneIsNullSymmetric() {
    final Node node4 = root.children.get(0).children.get(0).children.get(0);
    assertThrows(NullPointerException.class,
        () -> assertEquals(node4, solution.getLowestCommonAncestor(root, null, node4))
    );
  }

}