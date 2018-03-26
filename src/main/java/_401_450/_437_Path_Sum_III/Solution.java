package _401_450._437_Path_Sum_III;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution { // todo
//  private final Map<Integer, Integer> cache = new HashMap<>();
//
//  public int pathSum(TreeNode root, int sum) {
//    cache.put(0, 1);
//    return pathSum(root, sum, 0);
//  }
//
//  private int pathSum(final TreeNode root, final int target, int curSum) {
//    if (root == null) {
//      return 0;
//    }
////    int count = 0;
////    cache.put(curSum + root.val, cache.getOrDefault(curSum + root.val, 0) + 1);
////    if (cache.containsKey(-target + curSum + root.val)) {
////      count += cache.get(-target + curSum + root.val);
////    }
////    count += pathSum(root.left, target, curSum + root.val);
////    count += pathSum(root.right, target, curSum + root.val);
////    cache.put(curSum + root.val, cache.get(curSum + root.val) - 1);
////    return count;
//    curSum += root.val;
//    int res = cache.getOrDefault(curSum - target, 0);    //See if there is a subarray curSum// equals to target
//    cache.put(curSum, cache.getOrDefault(curSum, 0) + 1);
//    //Extend to left and right child
//    res += pathSum(root.left, curSum, target) + pathSum(root.right, curSum, target);
//    cache.put(curSum, cache.get(curSum) - 1);   //Remove the current node so it wont affect other path
//    return res;
//  }

  public int pathSum(TreeNode root, int sum) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);  //Default sum = 0 has one count
    return backtrack(root, 0, sum, map);
  }

  //BackTrack one pass
  public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
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


//  public int pathSum(TreeNode root, int sum) {
//    HashMap<Integer, Integer> preSum = new HashMap();
//    preSum.put(0,1);
//    return helper(root, 0, sum, preSum);
//  }

  public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
    if (root == null) {
      return 0;
    }

    currSum += root.val;
    int res = preSum.getOrDefault(currSum - target, 0);
    preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

    res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
    preSum.put(currSum, preSum.get(currSum) - 1);
    return res;
  }
}

