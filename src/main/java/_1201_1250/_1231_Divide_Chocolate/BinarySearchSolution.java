package _1201_1250._1231_Divide_Chocolate;

/**
 * @author jacka
 * @version 1.0 on 12/6/2019
 */
public final class BinarySearchSolution implements Solution {
  @Override
  public int maximizeSweetness(int[] sweetness, int K) {
    /*
    这个用binary search还是很头痛的，因为条件很难确定
    1) 选择第一个使得能够array分成k份的sum值，使得每个subarray sum均大于等于 minSum, 那么就有可能产生这样的情况，
    如果 minSum是5，但是最小的是所有subarray的sum是6，其实没有办法使得subarray sum变成5，5只是可以开始的值
    所以应当选用最后一个使得array能分成k组最小sum的值
    */
    final int sum = getSum(sweetness);
    K++;
    int left = 0, right = sum;
    while (left < right) {
      // last mid
      final int mid = left + (1 + right - left) / 2;
//      System.out.println(mid + ", left = " + left + ", right = " + right);
      if (getCount(mid, sweetness) > K) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private static int getCount(final int sum, final int[] sweetness) {
    int curSum = 0, count = 1;
    for (int n : sweetness) {
      curSum += n;
      if (curSum >= sum) {
        count++;
        curSum = 0;
      }
    }
// 这段代码不用，如果剩下的不足sum，应该扔到最后一组，不应该单独算一组
//    if (sum > 0) {
//      count++;
//    }

    return count;
  }

  private static int getSum(final int[] sweetness) {
    int sum = 0;
    for (int num : sweetness) {
      sum += num;
    }
    return sum;
  }
}
