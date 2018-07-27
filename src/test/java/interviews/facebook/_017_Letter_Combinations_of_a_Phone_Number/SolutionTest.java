package interviews.facebook._017_Letter_Combinations_of_a_Phone_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void test2() {
    assertEquals(new HashSet<>(Arrays.asList("a", "b", "c")),
        new HashSet<>(solution.letterCombinations("2")
        ));
  }

  @Test
  public void test23() {
    assertEquals(new HashSet<>(Arrays.asList("ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf")),
        new HashSet<>(solution.letterCombinations("23")
        ));
  }
}