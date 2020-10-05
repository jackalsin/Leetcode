package utils._843_Guess_the_Word;

public interface Master {
  /**
   * You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the
   * original list with 6 lowercase letters.
   * <p>
   * This function returns an integer type, representing the number of exact matches (value and position) of your guess
   * to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.
   *
   * @param word
   * @return
   */
  int guess(String word);

  /**
   * @return true when there is a guess matches the secret
   */
  boolean hit();
}
