package _0201_0250._223_Rectangle_Area;

/**
 * @author jacka
 * @version 1.0 on 8/15/2017.
 */
public class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int area1 = (C - A) * (D - B);
    int area2 = (G - E) * (H - F);
    int left = Math.max(A, E), right = Math.min(C, G),
        top = Math.min(D, H), bottom = Math.min(B, F);
    int together = 0;
    if (left < right && top > bottom) {
      together = (right - left) * (top - bottom);
    }
    return area1 - together + area2;
  }

}
