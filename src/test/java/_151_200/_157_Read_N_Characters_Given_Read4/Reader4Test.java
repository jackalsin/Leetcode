package _151_200._157_Read_N_Characters_Given_Read4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/19/2017.
 */
public class Reader4Test {
  private Reader4 reader4;

  @Before
  public void setUp() throws Exception {
    reader4 = new Reader4();
  }

  @Test
  public void test3Chars() throws Exception {
    final char[] input = "avc".toCharArray();
    assertEquals(3, reader4.read4(input));
    assertEquals(0, reader4.read4(input));
  }

}
