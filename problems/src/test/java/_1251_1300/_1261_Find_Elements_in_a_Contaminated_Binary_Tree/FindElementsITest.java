package _1251_1300._1261_Find_Elements_in_a_Contaminated_Binary_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/15/2021
 */
class FindElementsITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<FindElements> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final TreeNode root = TreeNodes.getTreeLevelOrder(-1, -1, -1, -1, -1);
    FindElements solution = solutionClass.getConstructor(TreeNode.class).newInstance(root);
    assertTrue(solution.find(1));
    assertTrue(solution.find(2));
    assertFalse(solution.find(5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<FindElements> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final TreeNode root = TreeNodes.getTreeLevelOrder(-1, null, -1);
    FindElements solution = solutionClass.getConstructor(TreeNode.class).newInstance(root);
    assertFalse(solution.find(1));
    assertTrue(solution.find(2));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        FindElementsI.class,
        FindElementsII.class
    );
  }

}