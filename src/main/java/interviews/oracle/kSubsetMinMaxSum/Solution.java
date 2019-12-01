package interviews.oracle.kSubsetMinMaxSum;

/**
 * @author zhixi
 * @version 1.0 on 11/30/2019
 */
public interface Solution {
  /**
   * 题目如下：
   * Given an array ,divide this array into k possible subsets and find the maximum sum of these subsets ,and from
   * these sum find the minimum among all?
   * 例子：
   * Let us say we have array[]={1,2,3} and k=2;
   * then the possible subsets are[{1},{2,3}],[{2},{1,3}],[{3},{1,2}];
   * here the maximum sum in 1st case i.e in[{1},{2,3}] is 5.
   * Similarly for 2nd case it is 4 ,in 3rd case it is 3 ,Now the minimum among all these is 3.
   *
   * @param nums
   * @param k
   * @return
   * @see <a herf="https://www.1point3acres.com/bbs/thread-572648-1-1.html">1point3acer</a>
   */
  int minMaxSum(final int[] nums, final int k);
}
