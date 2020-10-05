package _1401_1450._1410_HTML_Entity_Parser;

import java.util.Map;

public final class SolutionI implements Solution {
  private static final Map<String, String> MAP = Map.of(
      "&quot;", "\"",
      "&apos;", "'",
      "&amp;", "&",
      "&gt;", ">",
      "&lt;", "<",
      "&frasl;", "/"
  );

  public String entityParser(String text) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < text.length(); ++i) {
      boolean hasMatch = false;
      for (final var e : MAP.entrySet()) {
        final String key = e.getKey(), val = e.getValue();
        if (text.startsWith(key, i)) {
          hasMatch = true;
          sb.append(val);
          i += key.length() - 1;
        }
      }
      if (hasMatch) continue;
      sb.append(text.charAt(i));
    }
    return sb.toString();
  }
}
