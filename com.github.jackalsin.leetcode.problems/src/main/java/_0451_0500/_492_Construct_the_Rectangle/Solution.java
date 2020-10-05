package _0451_0500._492_Construct_the_Rectangle;

public class Solution {
  /**
   * 50 / 50 test cases passed.
   * Status: Accepted
   * Runtime: 5 ms
   *
   * @param area
   * @return
   */
  public int[] constructRectangle(int area) {
    for (int w = (int) Math.sqrt(area); w > 0; w--) {
      if (area % w == 0) {
        final int l = area / w;
        return new int[]{l, w};
      }
    }
    throw new IllegalStateException("Not found for area = " + area);
  }
}
