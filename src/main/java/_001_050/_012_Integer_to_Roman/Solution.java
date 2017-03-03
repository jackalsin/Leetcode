package _001_050._012_Integer_to_Roman;

/**
 * @author jacka
 * @version 1.0 on 2017/1/18.
 */
public class Solution {

  private final StringBuilder ansBuilder = new StringBuilder();

  /**
   * Take an integer num to Roman number.
   * Input is guaranteed to be within the range from 1 to 3999.
   *
   * @param num integer number.
   * @return Roman number
   */
  public String intToRoman(int num) {
    int remain = num;
    for (int i = 1000; i > 0; i /= 10) {
      remain = setDigits(remain, i);
    }
    return ansBuilder.toString();
  }

  private int setDigits(int remain, int base) {
    int digit = remain / base;
    switch (base) {
      case 1:
        addDigit(digit, "I", "V", "X");
        break;
      case 10:
        addDigit(digit, "X", "L", "C");
        break;
      case 100:
        addDigit(digit, "C", "D", "M");
        break;
      case 1000:
        addDigit(digit, "M", "", "");
        break;
      default:
        throw new IllegalArgumentException("Not acceptable base = " + base);
    }
    return remain - digit * base;
  }

  private void addDigit(int digit, final String one, final String five, final String ten) {
    switch (digit) {
      case 0:
      case 1:
      case 2:
      case 3:
        stringRepeat(digit, one);
        break;
      case 5:
      case 6:
      case 7:
      case 8:
        ansBuilder.append(five);
        stringRepeat(digit % 5, one);
        break;
      case 4:
        ansBuilder.append(one).append(five);
        break;
      case 9:
        ansBuilder.append(one).append(ten);
        break;
    }
  }

  private void stringRepeat(int times, String c) {
    for (int i = 0; i < times; i++) {
      ansBuilder.append(c);
    }
  }

}
