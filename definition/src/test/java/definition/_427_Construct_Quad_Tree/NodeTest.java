package definition._427_Construct_Quad_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/15/2021
 */
class NodeTest {

  @ParameterizedTest
  @MethodSource("streamArguments")
  void testLeafExactlySame(final boolean expected, final boolean isLeaf1, final boolean isLeaf2,
                           final boolean val1, final boolean val2) {
    final Node node1 = new Node(),
        node2 = new Node();
    node1.isLeaf = isLeaf1;
    node2.isLeaf = isLeaf2;
    node1.val = val1;
    node2.val = val2;
    assertEquals(expected, node1.equals(node2));
  }

  static Stream<Arguments> streamArguments() {
    return Stream.of(
        Arguments.of(true, true, true, true, true),
        Arguments.of(false, true, true, false, true),
        Arguments.of(false, true, true, true, false),
        Arguments.of(true, true, true, false, false),
        Arguments.of(false, true, false, true, true),
        Arguments.of(false, false, true, true, true),
        // if both false, the value doesn't matter as long as the four children are the same
        Arguments.of(true, false, false, true, true)
    );
  }
}