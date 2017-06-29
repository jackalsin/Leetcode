package _101_150._126_Word_Ladder_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This solution is simply using DFS, this test case will get TLE under such test case:
 *  abc -> abd, but 'abd' can be reached much early than the current path, which largely increase
 *  the time.
 *
 * @author Zhiwei.Xin
 * @version 1.0 on 6/27/2017.
 */
public class TLESolution {

  private Map<String, Set<String>> validPairs;
  /**
   *
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    generateValidPairs(beginWord, wordList);
    List<List<String>> result = new ArrayList<>();
    List<String> curPath = new ArrayList<>();
    curPath.add(beginWord);
    findLadders(result, curPath, validPairs.get(beginWord), beginWord, endWord);
    return result;
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

  private void findLadders(List<List<String>> result, List<String> curPath, Collection<String> candidates,
                           String beginWord, String endWord) {
    System.out.println("Result = " + result);
    System.out.println("curPath = " + curPath);
    System.out.println("candidates = " + candidates);
    System.out.println("beginWord = " + beginWord);
    if (!curPath.isEmpty() && curPath.get(curPath.size() - 1).equals(endWord)) {
      if (!result.isEmpty()) {
        int minSizeForCurPath = result.get(0).size();
        if (minSizeForCurPath >= curPath.size()) {
          if (minSizeForCurPath > curPath.size()) {
            result.clear();
          }
          updateResult(result, curPath);
        }
      } else {
        updateResult(result, curPath);
      }
    } else {
      if (!result.isEmpty() && result.get(0).size() <= curPath.size()) return;
//      Set<String> candidatesForChild = new HashSet<>(candidates);
      for (String child : candidates) {
        if (!validPairs.containsKey(child)) {// child 在validPair里remove掉了
          continue;
        }
        if (isValidCached(beginWord, child)) {
          Set<String> beginWordCandidates = validPairs.get(beginWord);
          validPairs.remove(beginWord);
          curPath.add(child);
          findLadders(result, curPath, validPairs.get(child), child, endWord);
          curPath.remove(curPath.size() - 1);
          validPairs.put(beginWord, beginWordCandidates);
        }
      }
    }
  }

  private void updateResult(List<List<String>> result, List<String> curPath) {
    result.add(new ArrayList<>(curPath));
  }

  private boolean isValidCached(String beginWord, String child) {
    return validPairs.get(beginWord).contains(child);
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


  public static void main(String[] args) {
    Map<String, Set<Integer>> map = new HashMap<>();
    Set<Integer> aSet = new HashSet<>();
      aSet.addAll(Arrays.asList(1, 2, 3, 4));
    final String key = "as";
    map.put(key, aSet);
    aSet.remove(2);
    System.out.println("Return a dup copy of result " + map.get(key).contains(2));
    System.out.println("Result = " + map.get(key));
  }
}
