package _0801_0850._843_Guess_the_Word;

import definition._843_Guess_the_Word.Master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class RandomSolution implements Solution {
  private static final int WORD_LEN = 6;

  public void findSecretWord(String[] wordlist, Master master) {
    final Random rand = new Random();
    List<String> wordList = Arrays.asList(wordlist);
    for (int k = 0, match = 0; k < 10 && match < WORD_LEN; k++) {
      final String picked = wordList.get(rand.nextInt(wordList.size()));
      match = master.guess(picked);
      final List<String> nextWordList = new ArrayList<>();
      for (String word2 : wordList) {
        if (match(picked, word2) == match) {
          nextWordList.add(word2);
        }
      } // end of the for loop
      wordList = nextWordList;
    }
  }

  private int match(final String word1, final String word2) {
    int match = 0;
    for (int i = 0; i < WORD_LEN; i++) {
      if (word1.charAt(i) == word2.charAt(i)) {
        match++;
      }
    }
    return match;
  }

}
