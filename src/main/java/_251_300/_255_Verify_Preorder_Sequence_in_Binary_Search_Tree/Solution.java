package _251_300._255_Verify_Preorder_Sequence_in_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/26/2017.
 */
public class Solution {
  public boolean verifyPreorder(int[] preorder) {
//    return logNSolution(preorder);
    return constantSpaceSolution(preorder);
  }

  private boolean logNSolution(int[] preorder) {
    Deque<Integer> stack = new ArrayDeque<>();
    int low = Integer.MIN_VALUE;
    for(int i : preorder) {
      if (i < low) {
        return false;
      } else {
        while (!stack.isEmpty() && i > stack.peek()) {
          low = stack.pop();
        }
        stack.push(i);
      }
    }
    return true;
  }

  private boolean constantSpaceSolution(int[] preorder) {
    int stackIndex = -1, low = Integer.MIN_VALUE;

    for(int i : preorder) {
      if (low >= i) {
        return false;
      } else {
        while (stackIndex != -1 && preorder[stackIndex] < i) {
          low = preorder[stackIndex--];
        }
        preorder[++stackIndex] = i;
      }
    }
    return true;
  }

}
