package definition._843_Guess_the_Word;

public final class MasterImpl implements Master {
  private static final int LEN = 6;
  private final String secret;

  private boolean hit = false;

  public MasterImpl(final String secret) {
    this.secret = secret;
  }

  @Override
  public int guess(String word) {
    if (word == null || word.length() != 6) {
      throw new IllegalArgumentException(
          "word should be a notnuallable string whose length equals 6, however, word = " + word);
    }

    int res = 0;
    for (int i = 0; i < LEN; i++) {
      if (secret.charAt(i) == word.charAt(i)) {
        res++;
      }
    }
    // if not hit, we need to evaluate if this time is a hit
    if (!hit) {
      hit = res == LEN;
    }
    return res;
  }

  @Override
  public boolean hit() {
    return hit;
  }
}
