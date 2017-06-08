package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public final class TreeNodes {
  private static final Set<Integer> VALID_LEN = new HashSet<>();

  static {
    for (int i = 0; i < 32; i++) {
      VALID_LEN.add((1 << i) - 1);
    }
  }

  private TreeNodes() {
  }

  public static TreeNode getTreePreorder(int[] vals) throws Exception {
    return null;
  }

  private static TreeNode getTreeInorder(int[] vals) {
    return getTreeInorder(vals, 0, vals.length - 1);
  }

  private static TreeNode getTreeInorder(int[] vals, int start, int end) {
    int valsLen = (end - start) / 2 + start;
    if (VALID_LEN.contains(valsLen)) {
      if (valsLen == 1) {
        return new TreeNode(vals[start]);
      } else {
        int rootVal = vals[valsLen / 2]; //3 -> 1: 0, 1, 2;
        TreeNode root = new TreeNode(rootVal);
        root.left = getTreeInorder(vals, start, valsLen / 2 - 1);
        root.right = getTreeInorder(vals, valsLen / 2 + 1, end);
        return root;
      }
    } else {
      return null;
    }
  }

  class Index {
    int index = 0;
  }

  class BinaryTree {
    Index index = new Index();

    // A recursive function to construct BST from pre[]. preIndex is used to keep track of index
    // in pre[].
    TreeNode constructTreeUtil(int pre[], Index preIndex, int key,
                               int min, int max, int size) {

      // Base case
      if (preIndex.index >= size) {
        return null;
      }

      TreeNode root = null;

      // If current element of pre[] is in range, then
      // only it is part of current subtree
      if (key > min && key < max) {

        // Allocate memory for root of this subtree and increment *preIndex
        root = new TreeNode(key);
        preIndex.index = preIndex.index + 1;

        if (preIndex.index < size) {

          // Contruct the subtree under root
          // All nodes which are in range {min .. key} will go in left
          // subtree, and first such node will be root of left subtree.
          root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index],
              min, key, size);

          // All nodes which are in range {key..max} will go in right
          // subtree, and first such node will be root of right subtree.
          root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index],
              key, max, size);
        }
      }
      return root;
    }

    // The main function to construct BST from given preorder traversal.
    // This function mainly uses constructTreeUtil()
    TreeNode constructTree(int pre[], int size) {
      int preIndex = 0;
      return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(TreeNode node) {
      if (node == null) {
        return;
      }
      printInorder(node.left);
      System.out.print(node.val + " ");
      printInorder(node.right);

    }
  }

}
