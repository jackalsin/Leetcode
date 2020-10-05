package hulu._200_Number_of_Islands.followUp;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public interface Solution {
  /**
   * 面试大概1小时左右， 上来问简历，然后问工作中最大的挑战是什么， 如何解决的 blabla。
   * 题目就是 里扣的 两白， 直接 floodfill了，
   * follow up： 如果输入没有边界(第一行跟最后一行， 第一列跟最后一列也算相邻) 怎么办 ？
   * <p>
   * [1,0,0]
   * [0,0,0]
   * [1,0,0]
   * 结果返回为 1
   * <p>
   * 加了个memo[][]来记录是否访问过， 然后i，j做处理 （i % matrix.length）(j % matrix[0].length)
   * <p>
   * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=541601&extra=page%3D1%26filter%3Dsortid%26sortid
   * %3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D107%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
   * %26orderby%3Ddateline
   */
  int numIslands(char[][] grid);
}
