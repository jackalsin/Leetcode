package interviews.airbnb.hilbertCurve;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public final class SolutionI implements Solution {


  /*
   顺带提及的知识点：
   如果坐标需要做rotation和reflection，所需要相乘的坐标都是以下：{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
   如果是reflection的话，原坐标不变，(x, y) => (x, y)然后乘以以上
   如果是rotation的话，原坐标需要互换，(x, y) => (y, x)然后乘以以上
  */
  public int hilbertCurve(int x, int y, int iter) {
    if (iter < 0) {
      throw new IllegalArgumentException();
    }
    if (x < 0) {
      throw new IllegalArgumentException();
    }
    if (y < 0) {
      throw new IllegalArgumentException();
    }

    if (iter == 0) {
      return 1;
    }
    final int midVal = 1 << (iter - 1);
    final int num = midVal * midVal;
    if (x >= midVal && y >= midVal) { // right top
      return 2 * num + hilbertCurve(x - midVal, y - midVal, iter - 1);
    } else if (y >= midVal) { // top left
      return num + hilbertCurve(x, y - midVal, iter - 1);
    } else if (x < midVal) { // left bottom
      return hilbertCurve(y, x, iter - 1);
    } else { // right bottom
      return 3 * num + hilbertCurve(midVal - 1 - y, 2 * midVal - 1 - x, iter - 1);
    }
  }

}
