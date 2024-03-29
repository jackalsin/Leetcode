package google.first_non_repeatable_char;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/20/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new OneMapSolution();
//    solution = new TwoMapSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String s = "abcdwofffwwwab";
    assertEquals('c', solution.firstNonRepeatableChar(s));

  }

}
