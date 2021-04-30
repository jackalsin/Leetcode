package facebook.practice.Rotational_Cipher;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String rotationalCipher(String input, int rotationFactor) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); ++i) {
      sb.append(getRotateChar(input.charAt(i), rotationFactor));
    }
    return sb.toString();
  }

  private static char getRotateChar(final char src, final int r) {
    final char candidate = (char) (src + r);
    if (Character.isDigit(src)) {
      if (candidate >= '9') return (char) ((candidate - '0') % 10 + '0');
      return candidate;
    } else if (Character.isUpperCase(src)) {
      if (candidate > 'Z') return (char) ((candidate - 'A') % 26 + 'A');
      return candidate;
    } else if (Character.isLowerCase(src)) {
      if (candidate > 'z') return (char) ((candidate - 'a') % 26 + 'a');
      return candidate;
    } else {
      return src;
    }
  }

}
