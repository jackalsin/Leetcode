package _1001_1050._1037_Valid_Boomerang;

/**
 * @author zhixi
 * @version 1.0 on 10/23/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isBoomerang(int[][] points) {
    final int dx1 = points[0][0] - points[1][0], dy1 = points[0][1] - points[1][1],
        dx2 = points[1][0] - points[2][0], dy2 = points[1][1] - points[2][1];
//    System.out.println(List.of(dx1, dy1, dx2, dy2));
    return dy1 * dx2 != dx1 * dy2;
  }
}
