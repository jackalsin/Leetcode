package _1251_1300._1261_Find_Elements_in_a_Contaminated_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.LinkedList;


/**
 * @author jacka
 * @version 1.0 on 4/14/2021
 */
public final class FindElementsI implements FindElements {
  private final TreeNode root;

  /*
  整体思路是
              0 (0)
            /     \
        1 (1)2    2 (10)
     /     \      /     \
  3 (11)  4(100) 5(101) 6(110)
  往左走是1，往右走是2
  但是%2只会产生1和0， 所以我们把 0 map 成 2
  6 % 2 = 0 => 6 = 2 + 2 * 2, so the parent of 6 is 2
  * */
  public FindElementsI(TreeNode root) {
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
    return find(target, root);
  }

  private boolean find(int target, final TreeNode root) {
    final LinkedList<DIRECT> directions = getDirect(target);
//    System.out.println(directions);
    return find(root, directions);
  }

  private boolean find(final TreeNode root, final LinkedList<DIRECT> direct) {
    if (root == null) return false;
    if (direct.isEmpty()) return true;
    final DIRECT toRemove = direct.removeFirst();
    if (toRemove == DIRECT.LEFT) {
      return find(root.left, direct);
    } else {
      return find(root.right, direct);
    }
  }

  private LinkedList<DIRECT> getDirect(final int target) {
    final LinkedList<DIRECT> result = new LinkedList<>();
    int cur = target;
    while (cur != 0) {
      final int r = cur % 2;
      result.addFirst(r == 0 ? DIRECT.RIGHT : DIRECT.LEFT);
      cur = (cur - (r == 0 ? 2 : 1)) / 2;
    }
    return result;
  }

  private enum DIRECT {
    LEFT, RIGHT
  }
}
