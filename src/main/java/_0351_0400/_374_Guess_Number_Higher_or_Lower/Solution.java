package _0351_0400._374_Guess_Number_Higher_or_Lower;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 11/7/2017.
 */
public class Solution extends GuessGame {

  public Solution(int n) {
    super(n);
  }

  public int guessNumber(int n) {
    int low = 1, high = n;
    while (low <= high) {
      int mid = (high - low) / 2 + low;
      int cmp = guess(mid);
      if (cmp == 0) {
        return mid;
      }
      if (cmp < 0) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    throw new IllegalStateException("n is not in the range");
  }
}
