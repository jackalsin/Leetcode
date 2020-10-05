package _0901_0950._919_Complete_Binary_Tree_Inserter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
class CBTInserterITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<CBTInserter> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final TreeNode root = new TreeNode(1), expectedAfterInsert1 = TreeNodes.getTreeLevelOrder(1, 2);
    final CBTInserter solution = cacheClass.getConstructor(TreeNode.class).newInstance(root);
    assertEquals(1, solution.insert(2));
    assertEquals(expectedAfterInsert1, solution.get_root());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<CBTInserter> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6),
        expected = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7, 8);
    final CBTInserter solution = cacheClass.getConstructor(TreeNode.class).newInstance(root);
    assertEquals(3, solution.insert(7));
    assertEquals(4, solution.insert(8));
    assertEquals(expected, solution.get_root());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        CBTInserterI.class
    );
  }
}