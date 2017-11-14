package _401_450._401_Binary_Watch;

import org.junit.Before;
import org.junit.Test;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final List<String> expected = new ArrayList<>(Arrays.asList("1:00", "2:00", "4:00", "8:00", "0:01","0:02","0:04", "0:08", "0:16", "0:32"));
    Collections.sort(expected);
    final List<String> actual = solution.readBinaryWatch(1);
    Collections.sort(actual);
    assertEquals(expected, actual);
  }

  @Test
  public void test0() throws Exception {
    final List<String> expected = List.of("0:00");
    final List<String> actual = solution.readBinaryWatch(0);
    assertEquals(expected, actual);
  }

}
