package _0401_0450._437_Path_Sum_III;

import definition.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public final class SampleSolution implements Solution {

  public int pathSum(TreeNode root, int sum) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);  //Default sum = 0 has one count
    return backtrack(root, 0, sum, map);
  }

  //BackTrack one pass
  private int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
    if (root == null)
      return 0;
    sum += root.val;
    int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    //Extend to left and right child
    res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
    map.put(sum, map.get(sum) - 1);   //Remove the current node so it wont affect other path
    return res;
  }

}

