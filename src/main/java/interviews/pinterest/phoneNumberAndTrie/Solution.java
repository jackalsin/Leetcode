package interviews.pinterest.phoneNumberAndTrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  //  后面一轮coding, 一位美国叔叔。交流极为不畅啊，不是说他人不好，他好耐心，尽力提示。但是我们两人somehow
// 没交流清楚题意，搞得我到最最后终于知道问的是啥，一开始一直想错，所以他一直要优化，我尽力顺着他说但实际是很疑惑的。
// 题目是combination of phone number 和 Tire
// 结合的变形题。给一个单词库，给个phone number，让你确定是否有个phone number 代表的字母组合在单词库里，并且输出在单词库的字母组合
  private static final Map<Character, List<Character>> MAP = new HashMap<>();

  static {
    MAP.put('2', Arrays.asList('a', 'b', 'c'));
    MAP.put('3', Arrays.asList('d', 'e', 'f'));
    MAP.put('4', Arrays.asList('g', 'h', 'i'));
    MAP.put('5', Arrays.asList('j', 'k', 'l'));
    MAP.put('6', Arrays.asList('m', 'n', 'o'));
    MAP.put('7', Arrays.asList('p', 'q', 'r', 's'));
    MAP.put('8', Arrays.asList('t', 'u', 'v'));
    MAP.put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }

  private static final int N = 26;
  private static final char BASE = 'a';

  public List<String> search(final List<String> words, final String phoneNum) {
    final Node root = new Node();
    for (String word : words) {
      insert(root, word, 0);
    }
    final List<String> result = new ArrayList<>();
    search(result, root, phoneNum, 0);
    return result;
  }

  private void search(List<String> result, Node root, String phoneNum, int i) {
    if (root == null) {
      return;
    }
    if (i == phoneNum.length()) {
      if (root.word != null) {
        result.add(root.word);
      }
      return;
    }

    final char digit = phoneNum.charAt(i);
    final List<Character> candidates = MAP.get(digit);
    for (char chr : candidates) {
      final int chrIndex = chr - BASE;
      if (root.next[chrIndex] != null) {
        search(result, root.next[chrIndex], phoneNum, i + 1);
      }
    }
  }

  private void insert(Node root, String word, int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - BASE; // move to base
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }

    insert(root.next[chrIndex], word, i + 1);
  }

  private static final class Node {
    private final Node[] next = new Node[N];
    private String word;
  }

}
