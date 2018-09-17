package interviews.linkedin._255_Verify_Preorder_Sequence_in_Binary_Search_Tree;

public class Solution {
  public boolean verifyPreorder(int[] preorder) {
    // TODO: 这方法有问题
    return verifyPreorder(preorder, 0, 1, preorder.length - 1);
  }

  private boolean verifyPreorder(final int[] preorder, final int rootIndex, final int start, final int end) {
    if (start >= end) {
      return true;
    }
    final int root = preorder[rootIndex];
    int left = start, right = end;
    while (left <= right) {
      if (preorder[left] < root) {
        left++;
      } else {
        break;
      }
    }

    for (int j = end; j >= left; j--) {
      if (preorder[j] <= root) {
        return false;
      }
    }

    return verifyPreorder(preorder, start + 1, start + 2, left - 1)
        && verifyPreorder(preorder, left, left + 1, end);
  }
}
