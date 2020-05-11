package interviews.linkedin._173_Binary_Search_Tree_Iterator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
class BSTIteratorTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1Null2(Class<BSTIterator> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 2);
    BSTIterator bstIterator = solutionClass.getConstructor(TreeNode.class).newInstance(root);
    assertEquals(1, bstIterator.next());
    assertEquals(2, bstIterator.next());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1To15(Class<BSTIterator> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final TreeNode root = TreeNodes.getTreeLevelOrder(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11,
        13, 15);
    BSTIterator bstIterator = solutionClass.getConstructor(TreeNode.class).newInstance(root);
    assertEquals(1, bstIterator.next());
    assertEquals(2, bstIterator.next());
    assertEquals(3, bstIterator.next());
    assertEquals(4, bstIterator.next());
    assertEquals(5, bstIterator.next());
    assertEquals(6, bstIterator.next());
    assertEquals(7, bstIterator.next());
    assertEquals(8, bstIterator.next());
    assertEquals(9, bstIterator.next());
    assertEquals(10, bstIterator.next());
    assertEquals(11, bstIterator.next());
    assertEquals(12, bstIterator.next());
    assertEquals(13, bstIterator.next());
    assertEquals(14, bstIterator.next());
    assertEquals(15, bstIterator.next());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        BSTIteratorI.class,
        BSTIteratorII.class,
        BSTIteratorIII.class,
        BSTIteratorIV.class
    );
  }
}
