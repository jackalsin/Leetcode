package _101_150._126_Word_Ladder_II;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/27/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    String beginWord = "hit";
    String endWord = "cog";
    final List<String> candidates = Arrays.asList("hot","dot","dog","lot","log","cog");

    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("hit","hot","dot","dog","cog"));
    expected.add(Arrays.asList("hit","hot","lot","log","cog"));
    List<List<String>> actual = solution.findLadders(beginWord, endWord, candidates);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void testEndWordNotInCandidates() throws Exception {
    String beginWord = "hit";
    String endWord = "cog";
    final List<String> candidates = Arrays.asList("hot","dot","dog","lot","log");

    List<List<String>> expected = new ArrayList<>();
    List<List<String>> actual = solution.findLadders(beginWord, endWord, candidates);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void testTLECase() throws Exception {
    String beginWord = "qa";
    String endWord = "sq";
    final List<String> candidates =
        Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av",
            "sm","ar","ci", "ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe",
            "ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if",
            "pb", "ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi",
            "os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io",
            "be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
//    List<List<String>> expected = new ArrayList<>();
    long startTime = System.nanoTime();
    List<List<String>> actual = solution.findLadders(beginWord, endWord, candidates);
    long endTime = System.nanoTime();
    System.out.println("TLE Case 1: " + (endTime - startTime) / 1E6 + " ms.");
    assertEquals(51, actual.size());
//    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }
}
