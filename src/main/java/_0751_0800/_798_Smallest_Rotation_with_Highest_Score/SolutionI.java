package _0751_0800._798_Smallest_Rotation_with_Highest_Score;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int bestRotation(int[] A) {
    /*How dosen score change when K++ ?
    Get point
      Each time when we rotate, we make index 0 to index N-1, then we get one more point.
      We know that for sure, so I don't need to record it.

    Lose point
      (i - A[i] + N) % N is the value of K making A[i]'s index just equal to A[i].
      For example, If A[6] = 1, then K = (6 - A[6]) % 6 = 5 making A[6] to index 1 of new array.
      So when K=5, we get this point for A[6]
      Then if K is bigger when K = (i - A[i] + 1) % N, we start to lose this point, making our score -= 1
      All I have done is record the value of K for all A[i] where we will lose points.

    A[i]=0
      Rotation makes no change for it, becasue we alwars have 0 <= index.
      However, it is covered in "get point" and "lose point".

    Explanation of codes
      Search the index where score decrease and record this changement to a list change.
      A simple for loop to calculate the score for every K value.
      score[K] = score[K-1] + change[K]
      In my codes I accumulated changes so I get the changed score for every K value compared to K=0
      Find the index of best score.
    */
    if (A == null || A.length == 0) {
      return 0;
    }
    final int N = A.length;
    final int[] change = new int[N];
    for (int i = 0; i < N; ++i) change[(i - A[i] + 1 + N) % N] -= 1;
    final int[] score = new int[N];
    int result = 0;
    for (int i = 1; i < N; ++i) {
      score[i] = score[i - 1] + change[i] + 1;
      if (score[i] > score[result]) {
        result = i;
      }
    }
    return result;
  }
}
