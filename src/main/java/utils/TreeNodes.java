package utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
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

  public static TreeNode getTreeLevelOrder(final int[] vals) {
    Integer[] boxed = Arrays.stream(vals).boxed().toArray( Integer[]::new );
    return getTreeLevelOrder(boxed);
  }

  public static TreeNode getTreeLevelOrder(Integer ... vals) {
    int count = 0;
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
