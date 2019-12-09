package interviews.oracle.randomNextWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 12/8/2019
 */
public final class HashMapSolution implements Solution {
  private final Map<String, List<Integer>> wordToIndex = new HashMap<>();
  private final List<String> words = new ArrayList<>();
  private final Random rand = new Random();

  @Override
  public void addWord(String word) {
    wordToIndex.computeIfAbsent(word, k -> new ArrayList<>()).add(words.size());
    words.add(word);
  }

  @Override
  public String getWord(String word) {
    final List<Integer> src = wordToIndex.getOrDefault(word, new ArrayList<>());
    final List<Integer> des = new ArrayList<>();
    for (int s : src) {
      if (s + 1 >= words.size()) continue;
      des.add(s + 1);
    }
    if (des.isEmpty()) {
      return null;
    }
    return words.get(des.get(rand.nextInt(des.size())));
  }
}
