package interviews.airbnb.lintcode_623_kEditDistance;

import java.util.ArrayList;
import java.util.List;

public final class SampleSolution implements Solution {
  /**
   * @param words: a set of stirngs
   * @param target: a target string
   * @param k: An integer
   * @return: output all the strings that meet the requirements
   */
  private TrieNode root;
  private String target;
  private int k;
  private int n;

  public List<String> kDistance(String[] words, String target, int k) {
    // write your code here
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    this.root = new TrieNode();
    this.target = target;
    this.k = k;
    for (int i = 0; i < words.length; i++) {
      insert(words[i]);
    }
    this.n = target.length();
    //initially, this dp array is for empty string ""
    //dp represents how many edit distance for empty string "" to form first i element of target
    int[] dp = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      dp[i] = i;
    }
    search(root, dp, result);
    return result;
  }

  private void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.map[c - 'a'] == null) {
        node.map[c - 'a'] = new TrieNode();
      }
      node = node.map[c - 'a'];
    }
    node.word = word;
  }

  private void search(TrieNode node, int[] prevDp, List<String> result) {
    if (node.word != null && prevDp[n] <= k) {
      result.add(node.word);
    }
    for (int i = 0; i < 26; i++) {
      if (node.map[i] == null) {
        continue;
      }
      int[] dp = new int[n + 1];
      //dp[0]是构建空字符串，如果之前的dp构建需要prevDp[0]步的话，现在多了一个字符，所以要删除多出的这个字符才能构建出空字符串，所以需要+1步
      dp[0] = prevDp[0] + 1;
      for (int j = 1; j <= n; j++) {
        //意思是target里的第j个字符等于当前对应的字符
        if (target.charAt(j - 1) - 'a' == i) {
          dp[j] = prevDp[j - 1];
        } else {
                    /* 如果dp[i][j]表示当前trie树所构成的prefix字符串的前i个字符和target字符串的前j个字符的编辑距离的话，按照以前的做法，如果当前第i个和第j个字符不相同的话，则有目前的对应关系：
                        dp[i - 1][j - 1] + 1 replace   => prevDp[j - 1] + 1
                        dp[i][j - 1] + 1 insert            => dp[j - 1] + 1
                        dp[i - 1][j] + 1 delete           => prevDp[j] + 1

                    */
          dp[j] = Math.min(prevDp[j - 1], Math.min(prevDp[j], dp[j - 1])) + 1;
        }
      }
      search(node.map[i], dp, result);
    }
  }

  private static final class TrieNode {
    TrieNode[] map;
    String word;

    TrieNode() {
      this.map = new TrieNode[26];
    }
  }


}
