package facebook.practice.Encrypted_Words;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String findEncryptedWord(String s) {
    return findEncryptedWord(s, 0, s.length() - 1).toString();
  }

  private StringBuilder findEncryptedWord(final String s, final int start, final int end) {
    final StringBuilder sb = new StringBuilder();
    if (start > end) return sb;
    final int mid = start + (end - start) / 2;
    sb.append(s.charAt(mid));
    sb.append(findEncryptedWord(s, start, mid - 1));
    sb.append(findEncryptedWord(s, mid + 1, end));
    return sb;
  }
}
