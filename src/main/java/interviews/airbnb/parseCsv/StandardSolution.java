package interviews.airbnb.parseCsv;

import java.util.ArrayList;
import java.util.List;

public final class StandardSolution implements Solution {
  public String parseCSV(String s) {
    final List<String> result = new ArrayList<>();
    final StringBuilder sb = new StringBuilder();
    boolean isInQuote = false;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (isInQuote) {
        if (chr == '"') {
          if (i + 1 < s.length() && s.charAt(i + 1) == '"') {
            sb.append('"');
            i++;
          } else {
            isInQuote = false;
          }
        } else {
          sb.append(chr);
        } // end of char == '"'
      } else {
        if (chr == '"') {
          isInQuote = true;
        } else if (chr == ',') {
          result.add(sb.toString());
          sb.setLength(0);
        } else {
          sb.append(chr); // what can come here
        }
      }
    }
    if (sb.length() > 0) {
      result.add(sb.toString());
    }
    return String.join("|", result);
  }
}
