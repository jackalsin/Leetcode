package _151_200._187_Repeated_DNA_Sequences;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/3/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String source = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    final List<String> expected = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");
    assertEquals(expected, solution.findRepeatedDnaSequences(source));
  }

  @Test
  public void test10Chars() throws Exception {
    final String source = "AAAAAAAAAAA";
    final List<String> expected = Arrays.asList("AAAAAAAAAA");
    assertEquals(expected, solution.findRepeatedDnaSequences(source));
  }
}
