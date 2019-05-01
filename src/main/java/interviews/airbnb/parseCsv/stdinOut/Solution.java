package interviews.airbnb.parseCsv.stdinOut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public final class Solution {
  //                                  name, age,                location,         interest
  private static final String FORMAT = "%s, %s years old, is from %s and is interested in %s.";

  public static void main(final String[] args) {
    final Solution solution = new Solution();
    try (
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))
    ) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        final List<String> items = solution.parse(line);
        bufferedWriter.write(String.format(FORMAT, items.get(0), items.get(6), items.get(5), items.get(3)));
        bufferedWriter.write(System.lineSeparator());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  /**
   * 0: first name,
   * 1: last name,
   * 2: email,
   * 3: interest,
   * 4: level(seems an enum),
   * 5: location,
   * 6: age
   *
   * @param line first name, last name, email, interest, level(seems an enum), location, age
   * @return
   */
  public List<String> parse(final String line) {
    final List<String> result = new ArrayList<>();
    final StringBuilder sb = new StringBuilder();
    boolean isInQuote = false;
    for (int i = 0; i < line.length(); i++) {
      final char chr = line.charAt(i);
      if (isInQuote) {
        if (chr == '"') {
          if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
            sb.append('"');
            i++;
          } else {
            isInQuote = false;
          }
        } else { // chr != '"'
          sb.append(chr);
        }
      } else { // not in the quote
        if (chr == '"') {
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

    return result;
  }
}
