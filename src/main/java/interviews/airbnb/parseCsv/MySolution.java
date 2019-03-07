package interviews.airbnb.parseCsv;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/6/2019.
 */
public final class MySolution implements Solution {
  /**
   * Replace the
   *
   * @param line
   * @return
   */
  public String parseCSV(final String line) {
    boolean isInQuote = false;
    final List<String> result = new ArrayList<>();
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < line.length(); i++) {
      final char chr = line.charAt(i);
      if (isInQuote) {
        if (chr == '"') {
          final int start = i;
          while (i + 1 < line.length() && line.charAt(i + 1) == '"') {
            i++;
          }
          if (i - start >= 1) {
            sb.append(chr);
          } else {
            isInQuote = false;
          }
        } else {
          sb.append(chr);
        }
      } else {
        if (chr == '"') {
          final int start = i;
          while (i + 1 < line.length() && line.charAt(i + 1) == '"') {
            i++;
          }
          if (i - start >= 1) {
            sb.append(chr);
          }
          isInQuote = true;
        } else if (chr == ',') {
          result.add(sb.toString());
          sb.setLength(0);
        } else {
          sb.append(chr);
        }
      }
    }
    if (sb.length() > 0) {
      result.add(sb.toString());
    }
    result.forEach(System.out::println);
    return String.join("|", result);
  }
}
