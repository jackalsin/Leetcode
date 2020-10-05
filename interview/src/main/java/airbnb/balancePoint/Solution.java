package airbnb.balancePoint;

import java.util.List;

public interface Solution {

  /**
   * 5. 跷跷板
   * 题目：给定一组数组（包含0），每一位表示该位置的重量，根据力矩*重量，计算该数组中一共有多少平衡点
   * 输入：一维数组
   * 输出：平衡点个数
   * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=519030&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D37%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
   *
   * @param weights
   * @return
   */
  List<Integer> getBalancePoints(int[] weights);
}
