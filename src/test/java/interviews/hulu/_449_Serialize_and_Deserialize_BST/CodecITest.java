package interviews.hulu._449_Serialize_and_Deserialize_BST;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
class CodecITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<Codec> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    Codec solution = solutionClass.getConstructor().newInstance();
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<Codec> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    Codec solution = solutionClass.getConstructor().newInstance();
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, null, 3);
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Class<Codec> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    Codec solution = solutionClass.getConstructor().newInstance();
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1);
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Class<Codec> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    Codec solution = solutionClass.getConstructor().newInstance();
    final TreeNode root = null;
    final TreeNode actual = solution.deserialize(solution.serialize(root));
    assertEquals(root, actual);
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        CodecI.class
    );
  }
}