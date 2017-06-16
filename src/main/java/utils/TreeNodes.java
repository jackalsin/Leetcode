package utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
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
  /*
    * http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html#3699291
    * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
    *
    * 2. 如果当前节点的左孩子不为空，在"当前节点的左子树"中找到当前节点在中序遍历下的前驱节点。
    *
    *    a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
    *
    *    b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
    *
    * 3. 重复以上1、2直到当前节点为空。
   */

  public static List<Integer> morrisTraversalInorder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    TreeNode curNode = root;
    TreeNode prevNode = null;
    while (curNode != null) {
      if (curNode.left == null) {
        result.add(curNode.val);
        curNode = curNode.right;
      } else {
        prevNode = curNode.left;
        while (prevNode.right != null && prevNode.right != curNode) {
          prevNode = prevNode.right;
        }
        if (prevNode.right == null) { // 2a: creating tail for right most node
          prevNode.right = curNode;
          curNode = curNode.left;
        } else { //  2b
          prevNode.right = null;
          result.add(curNode.val);
          curNode = curNode.right;
        }
      }

    }
    return result;
  }

  public static TreeNode getTreeLevelOrder(final int[] vals) {
    Integer[] boxed = Arrays.stream(vals).boxed().toArray( Integer[]::new );
    return getTreeLevelOrder(boxed);
  }

  public static TreeNode getTreeLevelOrder(Integer ... vals) {
    int count = 0;
    if (vals== null || vals.length == 0) return null;
    TreeNode root = new TreeNode(vals[0]);
    TreeNode cur = null;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    for(int i = 1; i < vals.length; i++) {
      TreeNode node = vals[i] == null ? null : new TreeNode(vals[i]);
      if (count == 0) {
        cur = queue.poll();
      }
      if (count == 0) {
        count++;
        cur.left = node;
      } else {
        count = 0;
        cur.right = node;
      }
      if (node != null) {
        queue.offer(node);

      }
    }
    return root;
  }

  /**
   * Generate a binary tree from an preordered values.
   * @param vals
   * @return
   */
  public static TreeNode getTreePreorder(int[] vals) {
    Integer[] boxed = Arrays.stream(vals).boxed().toArray( Integer[]::new );
    index = new Index();
    return getTreePreorder(boxed, index, vals[index.index],
        Integer.MIN_VALUE, Integer.MAX_VALUE, vals.length);
  }

  public static TreeNode getTreePreorder(Integer ... vals) {
    index = new Index();
    return getTreePreorder(vals, index, vals[index.index],
        Integer.MIN_VALUE, Integer.MAX_VALUE, vals.length);
  }

  // ---------------------- private methods -----------------------------------------
  private static class Index {
    int index = 0;
  }

  private static Index index = new Index();

  private static TreeNode getTreePreorder(Integer[] vals, Index preIndex, Integer key, int min,
                                          int max, int size) {
    // Base case
    if (preIndex.index >= size) {
      return null;
    }
    TreeNode root = null;
    // If current element of pre[] is in range, then only it is part of current subtree
    if (key != null) {
      if (Integer.compare(key, min) > 0 && Integer.compare(key, max) < 0) {
        // Allocate memory for root of this subtree and increment *preIndex
        root = new TreeNode(key);
        preIndex.index = preIndex.index + 1;
        if (preIndex.index < size) {
          // Contruct the subtree under root
          // All nodes which are in range {min .. key} will go in left
          // subtree, and first such node will be root of left subtree.
          root.left = getTreePreorder(vals, preIndex, vals[preIndex.index], min, key, size);
          root.right = getTreePreorder(vals, preIndex, vals[preIndex.index], key, max, size);
        }
      }
    } else {
      preIndex.index = preIndex.index + 1;
    }
    return root;
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
}
