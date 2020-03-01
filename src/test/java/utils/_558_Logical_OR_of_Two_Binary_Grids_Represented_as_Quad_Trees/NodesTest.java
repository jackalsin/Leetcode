package utils._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/29/2020
 */
class NodesTest {

  @Test
  void testOnlineCase1() {
    // [isLeaf, val].
    final int[][] input = {{0, 1}, {1, 1}, {1, 1}, {1, 0}, {1, 0}};
    final Node topLeft = new Node(true, true, null, null, null, null);
    final Node topRight = new Node(true, true, null, null, null, null);
    final Node bottomLeft = new Node(false, true, null, null, null, null);
    final Node bottomRight = new Node(false, true, null, null, null, null);
    final Node expected = new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    final Node actual = Nodes.get(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final int[][] input = {{0, 1},
        {1, 1}, {0, 1}, {1, 1}, {1, 0},
        null, null, null, null, {1, 0}, {1, 0}, {1, 1}, {1, 1}};
    final Node actual = Nodes.get(input);
    final Node topRightTopLeft = new Node(false, true, null, null, null, null);
    final Node topRightTopRight = new Node(false, true, null, null, null, null);
    final Node topRightBottomLeft = new Node(true, true, null, null, null, null);
    final Node topRightBottomRight = new Node(true, true, null, null, null, null);
    final Node topLeft = new Node(true, true, null, null, null, null);
    final Node topRight = new Node(true, false, topRightTopLeft, topRightTopRight, topRightBottomLeft,
        topRightBottomRight);
    final Node bottomLeft = new Node(true, true, null, null, null, null);
    final Node bottomRight = new Node(false, true, null, null, null, null);
    final Node expected = new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    assertEquals(expected, actual);
  }
}