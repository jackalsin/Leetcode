package airbnb.guessNumber;

public final class Server {
  private final String num;
  private static final int N = 4;

  public Server(final String num) {
    if (num == null || num.length() != N) {
      throw new IllegalArgumentException(num);
    }
    this.num = num;
  }

  public String get(final String guess) {
    if (guess == null || guess.length() != N) {
      throw new IllegalArgumentException(guess);
    }
    int exact = 0, misPos = 0;
    final int[] count = new int[10];
    for (int i = 0; i < guess.length(); i++) {
      final int n = num.charAt(i) - '0', g = guess.charAt(i) - '0';
      if (n == g) {
        exact++;
      } else {
        if (count[n] < 0) misPos++;
        if (count[g] > 0) misPos++;
        count[g]--;
        count[n]++;
      }
    }
    return exact + " " + misPos;
  }
}
