package interviews.byteDance.threeColorBinaryTree;

import java.util.Arrays;
import java.util.Objects;

import static interviews.byteDance.threeColorBinaryTree.SolutionI.COLOR.BLUE;
import static interviews.byteDance.threeColorBinaryTree.SolutionI.COLOR.GREEN;
import static interviews.byteDance.threeColorBinaryTree.SolutionI.COLOR.RED;


/**
 * @author jacka
 * @version 1.0 on 5/12/2020
 */
public final class SolutionI implements Solution {
  private static final int TOTAL_COLORS = 3;
  private int i = 0;

  /**
   * @see <a href="https://blog.csdn.net/bit_Line/article/details/41286393">more explanation</a>
   */
  @Override
  public int[] minMaxGreenColor(String treeSerialization) {
    if (treeSerialization == null || treeSerialization.length() == 0) {
      throw new IllegalArgumentException();
    }
    final TreeNode root = buildTree(treeSerialization);
    dp(root);
//    {min, max}
    final int[] res = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
    for (int i = 0; i < TOTAL_COLORS; ++i) {
      res[0] = Math.min(res[0], root.minGreen[i]);
      res[1] = Math.max(res[1], root.maxGreen[i]);
    }
//    System.out.println(root);
    return res;
  }

  private void dp(final TreeNode root) {
    if (root == null) {
      return;
    }
    dp(root.left);
    dp(root.right);
    if (root.left == null && root.right == null) {
      root.minGreen[GREEN.value] = root.maxGreen[GREEN.value] = 1;
    } else if (root.left == null) {
      assert root.right != null;
      root.maxGreen[GREEN.value] = Math.max(root.right.maxGreen[RED.value], root.right.maxGreen[BLUE.value]) + 1;
      root.maxGreen[BLUE.value] = Math.max(root.right.maxGreen[GREEN.value], root.right.maxGreen[RED.value]);
      root.maxGreen[RED.value] = Math.max(root.right.maxGreen[GREEN.value], root.right.maxGreen[BLUE.value]);

      root.minGreen[GREEN.value] = Math.min(root.right.minGreen[RED.value], root.right.minGreen[BLUE.value]) + 1;
      root.minGreen[BLUE.value] = Math.min(root.right.minGreen[GREEN.value], root.right.minGreen[RED.value]);
      root.minGreen[RED.value] = Math.min(root.right.minGreen[GREEN.value], root.right.minGreen[BLUE.value]);

    } else if (root.right == null) {
      root.maxGreen[GREEN.value] = Math.max(root.left.maxGreen[RED.value], root.left.maxGreen[BLUE.value]) + 1;
      root.maxGreen[BLUE.value] = Math.max(root.left.maxGreen[GREEN.value], root.left.maxGreen[RED.value]);
      root.maxGreen[RED.value] = Math.max(root.left.maxGreen[GREEN.value], root.left.maxGreen[BLUE.value]);

      root.minGreen[GREEN.value] = Math.min(root.left.minGreen[RED.value], root.left.minGreen[BLUE.value]) + 1;
      root.minGreen[BLUE.value] = Math.min(root.left.minGreen[GREEN.value], root.left.minGreen[RED.value]);
      root.minGreen[RED.value] = Math.min(root.left.minGreen[GREEN.value], root.left.minGreen[BLUE.value]);
    } else {
      root.maxGreen[GREEN.value] = Math.max(root.left.maxGreen[RED.value] + root.right.maxGreen[BLUE.value],
          root.left.maxGreen[BLUE.value] + root.right.maxGreen[RED.value]) + 1;
      root.maxGreen[RED.value] = Math.max(root.left.maxGreen[GREEN.value] + root.right.maxGreen[BLUE.value],
          root.left.maxGreen[BLUE.value] + root.right.maxGreen[GREEN.value]);
      root.maxGreen[BLUE.value] = Math.max(root.left.maxGreen[RED.value] + root.right.maxGreen[GREEN.value],
          root.left.maxGreen[GREEN.value] + root.right.maxGreen[RED.value]);

      root.minGreen[GREEN.value] = Math.min(root.left.minGreen[RED.value] + root.right.minGreen[BLUE.value],
          root.left.minGreen[BLUE.value] + root.right.minGreen[RED.value]) + 1;
      root.minGreen[RED.value] = Math.min(root.left.minGreen[GREEN.value] + root.right.minGreen[BLUE.value],
          root.left.minGreen[BLUE.value] + root.right.minGreen[GREEN.value]);
      root.minGreen[BLUE.value] = Math.min(root.left.minGreen[RED.value] + root.right.minGreen[GREEN.value],
          root.left.minGreen[GREEN.value] + root.right.minGreen[RED.value]);
    }
  }

  TreeNode buildTree(final String s) {
    if (i >= s.length()) {
      return null;
    }
    final TreeNode root = new TreeNode();
    final char chr = s.charAt(i++);
    if (chr == '0') {
    } else if (chr == '1') {
      root.left = buildTree(s);
    } else {
      root.left = buildTree(s);
      root.right = buildTree(s);
    }
    return root;
  }

  static final class TreeNode {
    TreeNode left, right;
    private final int[] maxGreen = new int[TOTAL_COLORS],
        minGreen = new int[TOTAL_COLORS];

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof TreeNode)) return false;
      TreeNode treeNode = (TreeNode) o;
      return Objects.equals(left, treeNode.left) &&
          Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
      return Objects.hash(left, right);
    }

    @Override
    public String toString() {
      return "TreeNode{" +
          "maxGreen=" + Arrays.toString(maxGreen) +
          ", minGreen=" + Arrays.toString(minGreen) +
          ", \nleft=" + left +
          ", \nright=" + right +
          '}';
    }
  }

  enum COLOR {

    GREEN(0), RED(1), BLUE(2), NONE(3);

    private final int value;

    COLOR(int value) {
      this.value = value;
    }
  }
}
