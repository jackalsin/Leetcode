package _351_400._374_Guess_Number_Higher_or_Lower;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 11/7/2017.
 */
public abstract class GuessGame {
  private final int n;

  public GuessGame(int n) {
    this.n = n;
  }

  /**
   * -1 : My number is lower 1 : My number is higher 0 : Congrats! You got it!
   */
  public int guess(int guess) {
    int cmp = Integer.compare(guess, n);
    if (cmp == 0) {
      return 0;
    } else if (cmp > 0) {
      return -1;
    } else {
      return 1;
    }
  }
}
