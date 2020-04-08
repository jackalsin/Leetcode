package _0851_0900._889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/7/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Integer> valToPostIndex = new HashMap<>();

  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    if (pre == null || pre.length == 0) {
      return null;
    }
    final int n = post.length;
    for (int i = 0; i < post.length; ++i) {
      valToPostIndex.put(post[i], i);
    }
    return constructFromPrePost(pre, post, 0, n - 1, 0, n - 1);
  }

  private TreeNode constructFromPrePost(final int[] pre, final int[] post, final int prevLeft, final int prevRight,
                                        final int postLeft, final int postRight) {
    if (prevLeft > prevRight) {
      return null;
    }
    if (prevLeft == prevRight) {
      assert postLeft == postRight;
      return new TreeNode(pre[prevLeft]);
    }
    final int rootVal = pre[prevLeft];
    final TreeNode root = new TreeNode(rootVal);
    final int leftSideEndInPost = valToPostIndex.get(pre[prevLeft + 1]),
        leftSideLen = leftSideEndInPost - postLeft + 1,
        rightStartInPrev = prevLeft + 1 + leftSideLen,
        rightStartInPost = postLeft + leftSideLen;
    root.left = constructFromPrePost(pre, post, prevLeft + 1, rightStartInPrev - 1, postLeft, rightStartInPost - 1);
    root.right = constructFromPrePost(pre, post, rightStartInPrev, prevRight, rightStartInPost, postRight - 1);
    return root;
  }
}
