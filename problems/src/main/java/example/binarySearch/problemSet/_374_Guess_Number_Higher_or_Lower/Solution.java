package example.binarySearch.problemSet._374_Guess_Number_Higher_or_Lower;

import _0351_0400._374_Guess_Number_Higher_or_Lower.GuessGame;

public class Solution extends GuessGame {
  Solution(int n) {
    super(n);
  }

  public int guessNumber(int n) {
    int left = 1, right = n;
    while (left <= right) {
      final int mid = (right - left) / 2 + left, cmp = guess(mid);
      if (cmp == 0) {
        return mid;
      } else if (cmp == -1) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    throw new IllegalStateException();
  }
}
