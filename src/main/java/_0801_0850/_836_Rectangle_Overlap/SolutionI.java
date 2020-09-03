package _0801_0850._836_Rectangle_Overlap;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    final int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3],
        x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];
    // 考虑1d，只需要left1 < right2 && left2 < right1;
    // 2D: 需要两个方向上投影重合
    return x3 < x2 && x1 < x4 && y3 < y2 && y1 < y4;
  }
}
