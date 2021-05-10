package google.guessWord;

/**
 * @author jacka
 * @version 1.0 on 5/9/2021
 */
public final class Machine {
  private final String word;
  public static final char MISS = '-';

  public Machine(final String word) {
    this.word = word;
  }

  public int getLength() {
    return word.length();
  }

  public String guess(final String word) {
    assert word.length() == this.word.length();
    final StringBuilder sb = new StringBuilder();

    for (int i = 0; i < word.length(); ++i) {
      if (word.charAt(i) == this.word.charAt(i)) {
        sb.append(word.charAt(i));
      } else {
        sb.append(MISS);
      }
    }
    return sb.toString();
  }
}
