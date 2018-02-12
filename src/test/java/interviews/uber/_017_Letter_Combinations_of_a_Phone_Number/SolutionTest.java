package interviews.uber._017_Letter_Combinations_of_a_Phone_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void test2() throws Exception {
    assertEquals(new HashSet<>(Arrays.asList("a", "b", "c")),
        new HashSet<>(solution.letterCombinations("2")
        ));
  }

  @Test
  void failedOnEmpty() throws Exception {
    assertEquals(new HashSet<>(), new HashSet<>(solution.letterCombinations("")));
  }

  @Test
  void test23() throws Exception {
    assertEquals(new HashSet<>(Arrays.asList("ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf")),
        new HashSet<>(solution.letterCombinations("23")
        ));
  }

}
