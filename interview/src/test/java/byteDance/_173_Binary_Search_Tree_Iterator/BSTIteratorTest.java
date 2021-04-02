package byteDance._173_Binary_Search_Tree_Iterator;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/1/2021
 */
class BSTIteratorTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOneElement(Class<BSTIterator> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    TreeNode root = TreeNodes.getTreeLevelOrder(1);
    BSTIterator bstIterator = solutionClass.getConstructor(TreeNode.class).newInstance(root);
    assertEquals(1, bstIterator.next());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTwoElements(Class<BSTIterator> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    BSTIterator bstIterator = solutionClass.getConstructor(TreeNode.class).newInstance(root);
    assertEquals(2, bstIterator.next());
    assertEquals(1, bstIterator.next());
    assertEquals(3, bstIterator.next());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<BSTIterator> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    TreeNode root = TreeNodes.getTreeLevelOrder(7, 3, 15, null, null, 9, 20);
    BSTIterator bstIterator = solutionClass.getConstructor(TreeNode.class).newInstance(root);
    assertEquals(3, bstIterator.next());
    assertEquals(7, bstIterator.next());
    assertTrue(bstIterator.hasNext());
    assertEquals(9, bstIterator.next());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        BSTIteratorI.class
    );
  }
}