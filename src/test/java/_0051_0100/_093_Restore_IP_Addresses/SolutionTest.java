package _0051_0100._093_Restore_IP_Addresses;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String input = "25525511135";
    final List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
    assertEquals(new HashSet<>(expected), new HashSet<>(solution.restoreIpAddresses(input)));
  }

  @Test
  public void testLeadingZero() throws Exception {
    final String input = "010010";
    final List<String> expected = Arrays.asList("0.10.0.10", "0.100.1.0");
    assertEquals(new HashSet<>(expected), new HashSet<>(solution.restoreIpAddresses(input)));
  }

  @Test
  public void testTLE() throws Exception {
    StringBuilder inputSb = new StringBuilder();
    for (int i = 0; i < 10_000; i++) {
      inputSb.append('1');
    }
    assertEquals(new HashSet<>(), new HashSet<>(solution.restoreIpAddresses(inputSb.toString())));
  }
}
