package utils.nAryTree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
class NodesTest {
  @Test
  void test428() {
    final Integer[] values = {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12,
        null, 13, null, null, 14};
    final Node expected = new Node(1, List.of(
        new Node(2),
        new Node(3, List.of(
            new Node(6),
            new Node(7, List.of(new Node(11, List.of(new Node(14)))))
        )),
        new Node(4, List.of(new Node(8, List.of(new Node(12))))),
        new Node(5, List.of(
            new Node(9, List.of(new Node(13))),
            new Node(10)
        ))
    )), actual = Nodes.getNode(values);
    assertEquals(expected, actual);
  }
}