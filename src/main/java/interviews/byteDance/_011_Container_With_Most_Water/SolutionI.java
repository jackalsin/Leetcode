package interviews.byteDance._011_Container_With_Most_Water;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxArea(int[] height) {
    int max = 0;
    for (int i = 0, j = height.length - 1; i <= j; ) {
      max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
      if (height[i] > height[j]) {
        --j;
      } else {
        ++i;
      }
    }
    return max;
  }
}
