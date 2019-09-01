package interviews.linkedin._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
class SolutionTest {

  private final TreeNode root = new TreeNode(6);

  Solution getSolution(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    return solutionClass.getConstructor().newInstance();
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testPEqualsQRoot(Class<Solution> solutionClass) throws InvocationTargetException, NoSuchMethodException,
      InstantiationException, IllegalAccessException {
    Solution solution = getSolution(solutionClass);
    assertEquals(root, solution.lowestCommonAncestor(root, root, root));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testPEqualsQNonRoot(Class<Solution> solutionClass) throws InvocationTargetException, NoSuchMethodException,
      InstantiationException, IllegalAccessException {
    Solution solution = getSolution(solutionClass);
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left, root.left));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testParent(Class<Solution> solutionClass) throws InvocationTargetException, NoSuchMethodException,
      InstantiationException, IllegalAccessException {
    Solution solution = getSolution(solutionClass);
    assertEquals(root.left.right, solution.lowestCommonAncestor(root, root.left.right,
        root.left.right.right));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testRegular(Class<Solution> solutionClass) throws InvocationTargetException, NoSuchMethodException,
      InstantiationException, IllegalAccessException {
    Solution solution = getSolution(solutionClass);
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left.left,
        root.left.right.right));
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        SolutionI.class,
        SolutionII.class
    );
  }

}