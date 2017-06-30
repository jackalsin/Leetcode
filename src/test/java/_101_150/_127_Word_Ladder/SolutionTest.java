package _101_150._127_Word_Ladder;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String beginWord = "hit";
    final String endWord = "cog";
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
    assertEquals(5, solution.ladderLength(beginWord, endWord, wordList));
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String beginWord = "hit";
    final String endWord = "cog";
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
    assertEquals(0, solution.ladderLength(beginWord, endWord, wordList));
  }

}
