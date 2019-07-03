package interviews.linkedin._127_Word_Ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
class BiDirectionBfsSolutionTest {

  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new BiDirectionBfsSolution();
  }

  @Test
  void testOnlineCase() {
    final String beginWord = "hit";
    final String endWord = "cog";
    final List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
    assertEquals(5, solution.ladderLength(beginWord, endWord, wordList));
  }

  @Test
  void testOnlineCase1() {
    final String beginWord = "hit";
    final String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
    assertEquals(0, solution.ladderLength(beginWord, endWord, wordList));
  }

  @Test
  void testOnlineCase2() {
    final String beginWord = "hit";
    final String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    assertEquals(5, solution.ladderLength(beginWord, endWord, wordList));
  }

  @Test
  void testStartEqualsEnd() {
    final String beginWord = "hit", endWord = "hit";
    final List<String> wordList = List.of(beginWord);
    assertEquals(0, solution.ladderLength(beginWord, endWord, wordList));
  }
}
