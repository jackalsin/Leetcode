package interviews.airbnb.hilbertCurve;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public interface Solution {


  /**
   * @param x
   * @param y
   * @param iter
   * @return the id (based on 1)
   */
  int hilbertCurve(int x, int y, int iter);

  default int sampleSolution(final int x, final int y, final int iter) {
    if (iter == 0) {
      return 1;
    }
    //count代表一个板块包含了多少步
    int count = 1 << (2 * (iter - 1));
    //len代表了一个板块的边长是多少
    int len = 1 << (iter - 1);

    if (x >= len && y >= len) {
      //右上角板块，从起点板块需要跨过两个板块到达
      return 2 * count + hilbertCurve(x - len, y - len, iter - 1);
    } else if (x < len && y >= len) {
      //左上角板块，从起点板块需要跨过一个板块到达
      return count + hilbertCurve(x, y - len, iter - 1);
    } else if (x < len && y < len) {
      //左下角起点板块，不需要跨过板块了，只需要rotation一下
      return hilbertCurve(y, x, iter - 1);
    } else {
      //右下角板块，从起点需要跨过三个板块到达，同时还需要rotation
      //用y = -x 对称，然后移动会起点Solution
      //做法是（x, y) => (-y, -x) => 向右移动len - 1，向上移动2* len - 1来移动回应该在的范围，其实就是rotation
      return 3 * count + hilbertCurve(len - 1 - y, 2 * len - 1 - x, iter - 1);
    }
  }

}
