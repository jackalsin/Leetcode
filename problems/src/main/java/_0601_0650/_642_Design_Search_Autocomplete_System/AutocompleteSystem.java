package _0601_0650._642_Design_Search_Autocomplete_System;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least
 * one word and end with a special character '#'). For each character they type except '#', you
 * need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:
 * The hot degree for a sentence is defined as the number of times a user typed the exactly same
 * sentence before.
 * The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one).
 * If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
 * If less than 3 hot sentences exist, then just return as many as you can.
 * When the input is a special character, it means the sentence ends, and in this case, you need
 * to return an empty list.
 * Your job is to implement the following functions:
 * The constructor function:
 * AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is
 * historical data. Sentences is a string array consists of previously typed sentences. Times is
 * the corresponding times a sentence has been typed. Your system should record these historical data.
 * Now, the user wants to input a new sentence. The following function will provide the next
 * character the user types:
 * List<String> input(char c): The input c is the next character typed by the user. The character
 * will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
 * Also, the previously typed sentence should be recorded in your system. The output will be
 * the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 * <p>
 * Example:
 * Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
 * The system have already tracked down the following sentences and their corresponding times:
 * "i love you" : 5 times
 * "island" : 3 times
 * "ironman" : 2 times
 * "i love leetcode" : 2 times
 * Now, the user begins another search:
 * <p>
 * Operation: input('i')
 * Output: ["i love you", "island","i love leetcode"]
 * Explanation:
 * There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have
 * same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode"
 * should be in front of "ironman". Also we only need to output top 3 hot sentences, so
 * "ironman" will be ignored.
 * <p>
 * Operation: input(' ')
 * Output: ["i love you","i love leetcode"]
 * Explanation:
 * There are only two sentences that have prefix "i ".
 * <p>
 * Operation: input('a')
 * Output: []
 * Explanation:
 * There are no sentences that have prefix "i a".
 * <p>
 * Operation: input('#')
 * Output: []
 * Explanation:
 * The user finished the input, the sentence "i a" should be saved as a historical sentence in
 * system. And the following input will be counted as a new search.
 * <p>
 * Note:
 * The input sentence will always start with a letter and end with '#', and only one blank space
 * will exist between two words.
 * The number of complete sentences that to be searched won't exceed 100. The length of each
 * sentence including those in the historical data won't exceed 100.
 * Please use double-quote instead of single-quote when you write test cases even for a character
 * input.
 * Please remember to RESET your class variables declared in class AutocompleteSystem, as
 * static/class variables are persisted across multiple test cases. Please see here for more details.
 * <p>
 * <p>
 * Solution 43 / 43 test cases passed.
 * Status: Accepted
 * Runtime: 380 ms
 *
 * @author jacka
 * @version 1.0 on 11/1/2017.
 */
public class AutocompleteSystem {
  private static final int N = 27;
  private static final int SPACE_INDEX = 26;
  private static final int MAX_RESULT = 3;

  private final Node root;

  private Node prevNode;
  private final StringBuilder curPath;

  public AutocompleteSystem(String[] sentences, int[] times) {
    curPath = new StringBuilder();
    root = new Node('1');
    for (int i = 0; i < sentences.length; i++) {
      buildTrie(sentences[i], times[i]);
    }
    prevNode = root;
  }

  private void buildTrie(String sentence, int time) {
    Node preNode = root;
    for (char chr : sentence.toCharArray()) {
      int idx = chr == ' ' ? SPACE_INDEX : chr - 'a';
      if (preNode.nodes[idx] == null) {
        preNode.nodes[idx] = new Node(chr);
      }
      preNode = preNode.nodes[idx];
    }
    preNode.counts = time;
    preNode.str = sentence;
  }

  public List<String> input(char c) {
    if (c == '#') { // record historical data
      if (prevNode == null) {
        buildTrie(curPath.toString(), 1);
      } else {
        prevNode.str = curPath.toString();
        prevNode.counts++;
      }
      prevNode = root;
      curPath.setLength(0);
      return new ArrayList<>();
    } else {
      curPath.append(c);
      LinkedList<String> result = new LinkedList<>();
      if (prevNode != null) {
        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
          @Override
          public int compare(Node o1, Node o2) {
            if (o1.counts == o2.counts) {
              return o2.str.compareTo(o1.str);
            }
            return Integer.compare(o1.counts, o2.counts);
          }
        });
        int idx = c == ' ' ? SPACE_INDEX : c - 'a';
        getResult(pq, prevNode.nodes[idx]);
        prevNode = prevNode.nodes[idx];
        while (!pq.isEmpty()) {
          result.addFirst(pq.poll().str);
        }
      }
      return result;
    }
  }

  private void getResult(Queue<Node> result, Node prevNode) {
    if (prevNode == null) return;
    if (prevNode.str != null) {
      updateQueue(result, prevNode);
    }
    for (Node node : prevNode.nodes) {
      if (node != null) {
        getResult(result, node);
      }
    }
  }

  private void updateQueue(Queue<Node> result, Node prevNode) {
    result.add(prevNode);
    if (result.size() == MAX_RESULT + 1) {
      result.poll();
    }
  }

  private static final class Node {
    private final char chr;
    private String str;
    private int counts;
    private final Node[] nodes;

    public Node(char chr) {
      nodes = new Node[N];
      this.chr = chr;
      str = null;
      counts = 0;
    }

  }
}
