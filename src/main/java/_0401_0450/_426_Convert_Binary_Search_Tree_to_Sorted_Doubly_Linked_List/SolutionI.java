package _0401_0450._426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List;


import utils.binaryTree.Node;

/**
 * @author jacka
 * @version 1.0 on 5/24/2020
 */
public final class SolutionI implements Solution {
  @Override
  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    final Node[] result = treeToDoublyListHelper(root);
    result[0].left = result[1];
    result[1].right = result[0];
    return result[0];
  }

  private static Node[] treeToDoublyListHelper(final Node root) {
    if (root == null) {
      return null;
    }
    final Node[] left = treeToDoublyListHelper(root.left),
        right = treeToDoublyListHelper(root.right);
    if (left == null && right == null) {
      return new Node[]{root, root};
    } else if (left == null) {
      root.right = right[0];
      right[0].left = root;
      return new Node[]{root, right[1]};
    } else if (right == null) {
      left[1].right = root;
      root.left = left[1];
      return new Node[]{left[0], root};
    } else {
      root.right = right[0];
      right[0].left = root;
      left[1].right = root;
      root.left = left[1];
      return new Node[]{left[0], right[1]};
    }
  }
}
