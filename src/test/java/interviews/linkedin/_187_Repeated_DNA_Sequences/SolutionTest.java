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
    solution = new SolutionII();
  }

  @Test
  public void testAAAAAAAAAAA() {
    final String input = "AAAAAAAAAAA";
    assertEquals(List.of("AAAAAAAAAA"), solution.findRepeatedDnaSequences(input));
  }

  @Test
  public void testAAAAACCCCCAAAAACCCCCCAAAAAGGGTTT() {
    final String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    assertEquals(List.of("AAAAACCCCC", "CCCCCAAAAA"), solution.findRepeatedDnaSequences(input));
  }

}
