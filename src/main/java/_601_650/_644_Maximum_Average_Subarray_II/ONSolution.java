package _601_650._644_Maximum_Average_Subarray_II;

import java.util.LinkedList;

/**
 * @author jacka
 * @version 1.0 on 12/26/2017.
 */
public class ONSolution implements Solution {
  int[] preSum;

  @Override
  public double findMaxAverage(int[] nums, int k) {
    int len = nums.length;
    preSum = new int[len];
    // get preSum array
    preSum[0] = nums[0];
    for (int i = 1; i < len; i++) {
      preSum[i] = preSum[i - 1] + nums[i];
    }
    // create the list such that for the range (i,j), element in this list would satisfy the
    // following condition
    // list[m]  list[m+1]-1 would be the smallest density from list[m] j.
    LinkedList<Integer> list = new LinkedList<Integer>();
    double res = -10000.0;
    for (int j = k - 1; j < len; j++) {
      // if the last point does not satisfy the condition, we need to remove it
      while (list.size() >= 2 &&
          getDensity(list.get(list.size() - 2), list.get(list.size() - 1) - 1) >= getDensity(list
              .get(list.size() - 2), j - k)
          ) {
        list.pollLast();
      }
      System.out.println("j =" + j + " list = " + list);
      list.add(j - k + 1);
      System.out.println(" j = " + j + " list = " + list);
      // all points are OK. If the first two point satisfy the condition, we need to remove the
      // first point. we need to find the max point
      while (list.size() >= 2 &&
          getDensity(list.get(0), list.get(1) - 1) <= getDensity(list.get(0), j)
          ) {
        list.pollFirst();
      }
      System.out.println("j =" + j + " list = " + list);
      res = Math.max(res, getDensity(list.get(0), j));
    }

    return res;
  }

  public double getDensity(int l, int r) {
    double res = 0.0;
    if (l == 0) {
      res = ((double) preSum[r]) / (1.0 + r);
    } else {
      res = ((double) preSum[r] - preSum[l - 1]) / (1.0 + r - l);
    }
    return res;
  }
}
