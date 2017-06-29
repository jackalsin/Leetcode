package _101_150._126_Word_Ladder_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/28/2017.
 */
public class SolutionPass implements Solution {
  private Map<String, Integer> distances;
  private Map<String, Set<String>> validPairs;

  @Override
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    long start1 = System.nanoTime();
    generateValidPairs(beginWord, wordList);
    long start2 = System.nanoTime();
    System.out.println("Find neighbors " + (start2 - start1) /  1E6 + " ms");
    bfsGenerateDistances(beginWord);
    long start3 = System.nanoTime();
    System.out.println("Generate Distances " + (start3 - start2) /  1E6 + " ms");
    List<List<String>> result = new ArrayList<>();
    List<String> curPath = new ArrayList<>();
    curPath.add(beginWord);
    dfsSearch(result, curPath, beginWord, endWord);
    return result;
  }

  private void dfsSearch(List<List<String>> result, final List<String> curPath,
                         final String beginWord, final String endWord) {
    if (!curPath.isEmpty() && curPath.get(curPath.size() - 1).equals(endWord)) {
      if (!result.isEmpty()) {
        int minSizeForCurPath = result.get(0).size();
        if (minSizeForCurPath >= curPath.size()) {
          if (minSizeForCurPath > curPath.size()) {
            result.clear();
          }
          result.add(new ArrayList<>(curPath));
        }
      } else {
        result.add(new ArrayList<>(curPath));
      }
    } else {
      final int depth = curPath.size();
      if (!result.isEmpty() && result.get(0).size() <= curPath.size()) return;
      Set<String> candidates = validPairs.get(beginWord);
      for (String candidate : candidates) {
        if (distances.get(candidate) == depth) {
          curPath.add(candidate);
          dfsSearch(result, curPath, candidate, endWord);
          curPath.remove(curPath.size() - 1);
        }
      }
    }
  }

  private void bfsGenerateDistances(String beginWord) {
    distances = new HashMap<>();
    int distance = 0;
    Queue<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      distance++;
      for (int i = 0; i < size; i++) {
        String curWord = queue.poll();
        Set<String> neighbors = validPairs.get(curWord);
        for (String neighbor: neighbors) {
          if (!distances.containsKey(neighbor)) { // mini step is not saved
            distances.put(neighbor, distance);
            queue.offer(neighbor);
          }
        }
      }
    }
  }

  private void generateValidPairs(String beginWord, List<String> wordList) {
    validPairs = new HashMap<>();
    List<String> words = new ArrayList<>(wordList);
    words.add(beginWord);
    for (int i = 0; i < words.size(); i++) {
      String word = words.get(i);
      Set<String> curWordSet = validPairs.getOrDefault(word, new HashSet<>());
      for (int j = i + 1; j < words.size(); j++) {
        String tgtWord = words.get(j);
        Set<String> tgtWordSet = validPairs.getOrDefault(tgtWord, new HashSet<>());
        if (isValid(word, tgtWord)) {
          tgtWordSet.add(word);
          curWordSet.add(tgtWord);
        }
        validPairs.put(tgtWord, tgtWordSet);
      }
      validPairs.put(word, curWordSet);
    }
  }

  private boolean isValid(String beginWord, String child) {
    int count = 0;
    for (int i = 0; i < beginWord.length(); i++) {
      if (beginWord.charAt(i) != child.charAt(i)) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return count != 0;
  }

}
