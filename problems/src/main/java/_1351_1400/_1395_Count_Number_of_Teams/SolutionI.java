package _1351_1400._1395_Count_Number_of_Teams;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int numTeams(int[] rating) {
    if (rating == null || rating.length < 2) {
      return 0;
    }
    final int N = rating.length;
    int count = 0;
    for (int i = 0; i < N; ++i) {
      int leftSmaller = 0, leftLarger = 0, rightSmaller = 0, rightLarger = 0;
      for (int j = 0; j < N; ++j) {
        if (i == j) continue;
        if (rating[i] < rating[j]) {
          if (i < j) {
            rightLarger++;
          } else {
            leftLarger++;
          }
        } else {
          if (i < j) {
            rightSmaller++;
          } else {
            leftSmaller++;
          }
        }
      }
//      System.out.printf("leftSmaller = %d, rightLarger = %d, leftLarger = %d, rightSmaller = %d\n",
//          leftSmaller, rightLarger, leftLarger, rightSmaller);
      count += leftSmaller * rightLarger + leftLarger * rightSmaller;
    }
    return count;
  }
}
