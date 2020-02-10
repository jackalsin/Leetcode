package interviews.hulu.maxRatio;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public interface Solution {
  /**
   * 7. 算法题是平面直角坐标系中给出一些点，找出能组成最大斜率的那两个点，
   * 时间要求优于n^2。面试时没想出来，后来查了下发现是道常考题。。。​平面上N个点，没两个点都确定一条直线，求出斜率最大的那条直线所通过的两个点（斜率不存在的情况不考虑）。时间效率越高越好先把N个点按x排序。斜率k
   * 最大值为max(斜率(point,point[i+1])) 0<=i<n-2。复杂度Nlog(N)
   * 。无论多少个点都可以任意选三个点组成一个三角形，那么斜率最大的边肯定是通过相邻的两个点，以此可知斜率最大的直线一点是由两个相邻的点画出的。
   */
  double maxRatio(final double[][] points);
}
