package tableau._297_Serialize_and_Deserialize_Binary_Tree;

import definition.binaryTree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/14/2020
 */
class CodecITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Codec solution) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  static Stream<Codec> solutionStream() {
    return Stream.of(
        new CodecI()
    );
  }
}