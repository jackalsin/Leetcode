package interviews.linkedin._449_Serialize_and_Deserialize_BST;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
class CodecTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Codec solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Codec solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, null, 3);
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Codec solution) {
    final TreeNode root = null;
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  static Stream<Codec> solutionProvider() {
    return Stream.of(
        new CodecON(),
        new CodecI(),
        new CodecII()
    );
  }
}