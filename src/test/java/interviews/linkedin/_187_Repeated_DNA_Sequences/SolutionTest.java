package interviews.linkedin._187_Repeated_DNA_Sequences;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testAAAAAAAAAAA() throws Exception {
    final String input = "AAAAAAAAAAA";
    System.out.println(input.length());
    assertEquals(List.of("AAAAAAAAAA"), solution.findRepeatedDnaSequences(input));
  }

}
