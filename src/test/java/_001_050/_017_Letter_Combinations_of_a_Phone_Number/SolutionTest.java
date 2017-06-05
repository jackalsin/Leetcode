package _001_050._017_Letter_Combinations_of_a_Phone_Number;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/21.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test2() throws Exception {
    assertEquals(new HashSet<>(Arrays.asList("a", "b", "c")),
        new HashSet<>(solution.letterCombinations("2")
        ));
  }

  @Test
  public void test23() throws Exception {
    assertEquals(new HashSet<>(Arrays.asList("ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf")),
        new HashSet<>(solution.letterCombinations("23")
        ));
  }
}