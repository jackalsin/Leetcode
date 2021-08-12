package _0251_0300._293_Flip_Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline() throws Exception {
    final String[] expected = {  "--++", "+--+", "++--"};
    final String input = "++++";
    final List<String> acutal = solution.generatePossibleNextMoves(input);
    assertEquals(new HashSet<>(Arrays.asList(expected)), new HashSet(acutal));
    assertEquals(expected.length, acutal.size());
  }

}
