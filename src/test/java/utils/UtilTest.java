package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.TwoDimensionArray.TwoDimensionArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/7.
 */
public class UtilTest {

  @Test
  public void getListOfNodes() throws Exception {
    ListNode actual = Util.getListOfNodes(new int[] {1, 2, 3});
    ListNode expect = new ListNode(1);
    ListNode expect2 = new ListNode(2);
    expect.next = expect2;
    ListNode expect3 = new ListNode(3);
    expect2.next = expect3;
    assertEquals(expect, actual);
  }
  // 2d array equals with char
  @Test
  public void test2dArrayEqualsCharTypeEmptyElement() throws Exception {
    final char[][] input = new char[][]{};
    assertTrue(TwoDimensionArrayEquals(input, input));
  }

}