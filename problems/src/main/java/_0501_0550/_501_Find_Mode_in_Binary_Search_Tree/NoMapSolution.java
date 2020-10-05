package _0501_0550._501_Find_Mode_in_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public final class NoMapSolution implements Solution {
  private int maxCount = 0;
  private Set<Integer> maxVals = new HashSet<>();

  @Override
  public int[] findMode(TreeNode root) {
    TreeNode cur = root;
    if (root == null) {
      return new int[0];
    }
    int curCount = 0, curVal = 0;

    while (cur != null) {
      if (cur.left == null) {
        // handle situation
        if (cur.val == curVal) {
          curCount++;
        } else {
          updateMax(curCount, curVal);
          curCount = 1;
          curVal = cur.val;
        }

        cur = cur.right;
      } else {
        TreeNode mostRightNode = cur.left;
        while (mostRightNode.right != null && mostRightNode.right != cur) {
          mostRightNode = mostRightNode.right;
        }
        if (mostRightNode.right == cur) {
          // handle situation
          if (cur.val == curVal) {
            curCount++;
          } else {
            updateMax(curCount, curVal);
            curCount = 1;
            curVal = cur.val;
          }

          mostRightNode.right = null;
          cur = cur.right;
        } else {
          mostRightNode.right = cur;
          cur = cur.left;
        }
      }
    }
    updateMax(curCount, curVal);

    final int[] res = new int[maxVals.size()];
    int i = 0;
    for (int child : maxVals) {
      res[i++] = child;
    }
    return res;
  }

  private void updateMax(int curMaxCounts, int curMax) {
    if (curMaxCounts > maxCount) {
      maxVals.clear();
      maxVals.add(curMax);
      maxCount = curMaxCounts;
    } else if (curMaxCounts == maxCount) {
      maxVals.add(curMax);
    }
  }
}
