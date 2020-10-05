package _0151_0200._158_Read_N_Characters_Given_Read4_II_Call_multiple_times;

import definition._157_Read_N_Characters_Given_Read4.Reader4;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class Solution extends Reader4{
  public Solution(String s) {
    super(s);
  }

  private int bp = 0;
  private int actual = 0;
  private char[] temp = new char[4];
  public int read(char[] buf, int n) {
    int count = 0;
    while(count < n) {
      if (bp == actual) {
        bp = 0;
        actual = read4(temp);
        if (actual == 0) break;
      }
      buf[count++] = temp[bp++];  
    }
    return count;
  }
}
