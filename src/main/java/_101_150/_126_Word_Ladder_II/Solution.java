package _101_150._126_Word_Ladder_II;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/27/2017.
 */
public class Solution {
  /**
   *
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    List<String> curPath = new ArrayList<>();
    curPath.add(beginWord);
    findLadders(result, curPath, wordList, beginWord, endWord);
    return result;
  }

  private void findLadders(List<List<String>> result, List<String> curPath, Collection<String> candidates,
                           String beginWord, String endWord) {
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
      for (String child : candidates) {
        Set<String> candidatesForChild = new HashSet<>(candidates);
        if (isValid(beginWord, child)) {
          candidatesForChild.remove(child);
          curPath.add(child);
          findLadders(result, curPath, candidatesForChild, child, endWord);
          curPath.remove(curPath.size() - 1);
        }
      }
    }
  }

  private void updateResult(List<List<String>> result, List<String> curPath) {
    result.add(new ArrayList<>(curPath));
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
    return true;
  }

}
