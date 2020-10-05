package google.similar_tree;

import utils.binaryTree.TreeNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/27/2018.
 */
public final class ONSolution implements Solution {
  @Override
  public boolean isSimilarTree(TreeNode root1, TreeNode root2) {
    Set<Map<Integer, Integer>> edges1 = getEdges(root1);
    Set<Map<Integer, Integer>> edges2 = getEdges(root2);

//    System.out.println(edges1);
//    System.out.println(edges2);
    return edges1.equals(edges2);
  }

  private Set<Map<Integer, Integer>> getEdges(TreeNode root1) {
    final Set<Map<Integer, Integer>> result = new HashSet<>();
    if (root1 == null) {
      return result;
    }
    result.addAll(getEdges(root1.left));
    result.addAll(getEdges(root1.right));
    if (root1.left != null) {
      result.add(Map.of(root1.val, root1.left.val));
    }
    if (root1.right != null) {
      result.add(Map.of(root1.val, root1.right.val));
    }
    return result;
  }

}
