package facebook._158_Read_N_Characters_Given_Read4_II_Call_multiple_time;

import definition._157_Read_N_Characters_Given_Read4.Reader4;

public class Solution extends Reader4 {
  public Solution(String s) {
    super(s);
  }


  private int tempPtr = 0;
  /* This records the max count (exclusive) that tempPtr can go */
  private int tempCount = 0;
  private char[] temp = new char[4];

  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return The number of characters read
   */
  public int read(char[] buf, int n) {
    int count = 0;
    while (count < n) {
      if (tempPtr == 0) {
        tempCount = read4(temp);
      }
      if (tempCount == 0) {
        break;
      }

      for (; tempPtr < tempCount && count < n; count++, tempPtr++) {
        buf[count] = temp[tempPtr];
      }

      if (tempPtr >= tempCount) {
        tempPtr = 0;
      }
    }
    return count;
  }

}
