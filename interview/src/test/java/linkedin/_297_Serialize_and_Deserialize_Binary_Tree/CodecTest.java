package linkedin._297_Serialize_and_Deserialize_Binary_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
class CodecTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Codec codec) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    assertEquals(root, codec.deserialize(codec.serialize(root)));
  }

  static Stream<Codec> solutionStream() {
    return Stream.of(
        new CodecI(),
        new CodecII(),
        new CodecIII(),
        new CodecIV(),
        new CodecV()
    );
  }
}
