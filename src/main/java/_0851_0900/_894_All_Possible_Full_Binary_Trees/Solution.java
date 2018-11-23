package _0851_0900._894_All_Possible_Full_Binary_Trees;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private final Map<Integer, List<TreeNode>> cache = new HashMap<>();

  public List<TreeNode> allPossibleFBT(int N) {
    if (cache.containsKey(N)) {
      return cache.get(N);
    }
    final List<TreeNode> result = new ArrayList<>();
    cache.put(N, result);
    if (N % 2 == 0) {
      return result;
    } else if (N == 1) {
      result.add(new TreeNode(0));
      return result;
    }

    for (int left = 1; left <= N - 1; left += 2) {
      final int right = N - 1 - left;
      final List<TreeNode> leftSides = allPossibleFBT(left), rightSides = allPossibleFBT(right);
      for (TreeNode leftSide : leftSides) {
        for (TreeNode rightSide : rightSides) {
          final TreeNode newRoot = new TreeNode(0);
          newRoot.left = leftSide;
          newRoot.right = rightSide;
          result.add(newRoot);
        }
      }
    }
    return result;
  }
}
