package google.guessWord;

/**
 * @author jacka
 * @version 1.0 on 5/9/2021
 */
public final class SolutionI implements Solution {
  private final Machine machine;
  private final int len;

  public SolutionI(final Machine machine) {
    this.machine = machine;
    len = machine.getLength();
  }

  @Override
  public String guessWord() {
    StringBuilder sb = new StringBuilder();
    fill(sb);
    for (int times = 0; ; ++times) {
      final String cur = sb.toString();
      final String answer = machine.guess(cur);
      if (cur.equals(answer)) return answer;
      System.out.println("times = " + times + ", answer = " + answer);
      sb = getNext(answer, cur);
    }
  }

  private StringBuilder getNext(final String answer, final String prev) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < prev.length(); ++i) {
      if (answer.charAt(i) == Machine.MISS) {
        sb.append((char) (prev.charAt(i) + 1));
      } else {
        sb.append(answer.charAt(i));
      }
    }
    return sb;
  }

  private void fill(final StringBuilder sb) {
    for (int i = 0; i < len; ++i) {
      sb.append('a');
    }
  }
}
