package interviews.tableau._297_Serialize_and_Deserialize_Binary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/14/2020
 */
class CodecITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Codec solution) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  static Stream<Codec> solutionProvider() {
    return Stream.of(
        new CodecI()
    );
  }
}