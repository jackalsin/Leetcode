package google._843_Guess_the_Word;

import utils._843_Guess_the_Word.Master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
public final class RandomSolution implements Solution {
  private final Random rand = new Random();

  public void findSecretWord(String[] wordlist, Master master) {
    List<String> words = new ArrayList<>(Arrays.asList(wordlist));
    for (int count = 0; count < 10 && !words.isEmpty(); count++) {
      final String guess = words.get(rand.nextInt(words.size()));
      final int match = master.guess(guess);
      if (match == 6) break;
      final List<String> nextWords = new ArrayList<>();
      for (String word : words) {
        final int curMatch = match(word, guess);
        if (curMatch == match) {
          nextWords.add(word);
        }
      }
//      System.out.println(String.format("guess %s match = %d, nextWords = %s", guess, match, nextWords));
      words = nextWords;
    }
  }

  private static int match(final String s, final String t) {
    int count = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == t.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}
