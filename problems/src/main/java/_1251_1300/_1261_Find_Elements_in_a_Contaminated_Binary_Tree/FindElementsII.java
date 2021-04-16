package _1251_1300._1261_Find_Elements_in_a_Contaminated_Binary_Tree;

import definition.binaryTree.TreeNode;


/**
 * @author jacka
 * @version 1.0 on 4/14/2021
 */
public final class FindElementsII implements FindElements {
  private final TreeNode root;

  /*
  整体思路是
              0 (0)
            /     \
        1 (1)2    2 (10)
     /     \      /     \
  3 (11)  4(100) 5(101) 6(110)

              1 (1)
            /       \
        2 (10)       3 (11)
     /     \      /     \
  4 (100)  5(101) 6(110) 7(111)

  往左走是0，往右走是1
  * */
  public FindElementsII(TreeNode root) {
    this.root = root;
    recover(root, 0);
  }

  private void recover(final TreeNode root, final int val) {
    if (root == null) return;
    root.val = val;
    recover(root.left, 2 * val + 1);
    recover(root.right, 2 * val + 2);
  }

  public boolean find(int target) {
    return find(root, target + 1);
  }

  private static boolean find(final TreeNode root, final int target) {
    final int len = getLen(target);
    int cur = target;
    TreeNode curNode = root;
    for (int i = len - 2, bit = 1 << i; i >= 0; --i, bit >>= 1) {
      final int d = (cur & bit) >> i;
      if (d == 1) {
        curNode = curNode.right;
      } else {
        curNode = curNode.left;
      }
      if (curNode == null) return false;
      cur -= bit;
    }
    return true;
  }

  private static int getLen(int target) {
    int len = 0;
    while (target != 0) {
      len++;
      target /= 2;
    }
    return len;
  }
}
