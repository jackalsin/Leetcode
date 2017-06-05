package _001_050._043_Multiply_Strings;

/**
 * @author jacka
 * @version 1.0 on 2/20/2017.
 */
public class Solution {
  public String multiply(String num1, String num2) {
    if (num1 == null || num1.isEmpty()) {
      throw new IllegalArgumentException("num1 cannot be null or empty, now nums1 = " + num1);
    }
    if (num2 == null || num2.isEmpty()) {
      throw new IllegalArgumentException("num2 cannot be null or empty, now nums2 = " + num2);
    }

    int[] resultArray = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; i--) {
      int iVal = num1.charAt(i) - '0';
      for (int j = num2.length() - 1; j >= 0; j--) {
        int jVal = num2.charAt(j) - '0';
        int sum = resultArray[j + i + 1] + jVal * iVal;
        resultArray[j + i + 1] = sum % 10;
        resultArray[j + i] += sum / 10; // though it can result a number greater than
                                                  // 10, but it can be reduced to one digit.
      }
    }

    StringBuilder sb = new StringBuilder();
    boolean isLeadingZero = true;
    for (int i : resultArray) {
      if (i != 0 || !isLeadingZero) {
        isLeadingZero = false;
        sb.append(i);
      }
    }
    return sb.length() == 0 ? "0" :sb.toString();
  }

}
