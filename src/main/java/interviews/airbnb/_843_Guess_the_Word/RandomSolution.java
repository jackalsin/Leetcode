package interviews.airbnb._843_Guess_the_Word;

import utils._843_Guess_the_Word.Master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
public final class RandomSolution implements Solution {
  private static final int WORD_LEN = 6, N = 10;
  private final Random rand = new Random();

  public void findSecretWord(String[] wordlist, Master master) {
    List<String> words = Arrays.asList(wordlist);

    for (int i = 0; i < N; i++) {
      final int randIndex = rand.nextInt(words.size());
      final String srcWord = words.get(randIndex);
      int match = master.guess(srcWord);
      final List<String> nextWords = new ArrayList<>();
      for (String w : words) {
        if (match(srcWord, w) == match) {
          nextWords.add(w);
        }
      }
      words = nextWords;
    }
  }

  private static int match(final String src, final String tgt) {
    int count = 0;
    for (int i = 0; i < WORD_LEN; i++) {
      if (src.charAt(i) == tgt.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}
