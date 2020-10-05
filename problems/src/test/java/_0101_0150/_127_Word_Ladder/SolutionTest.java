package _0101_0150._127_Word_Ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/29/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    final String beginWord = "hit";
    final String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    assertEquals(5, solution.ladderLength(beginWord, endWord, wordList));
  }

  @Test
  void testOnlineCase1() {
    final String beginWord = "hit";
    final String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
    assertEquals(0, solution.ladderLength(beginWord, endWord, wordList));
  }

}
