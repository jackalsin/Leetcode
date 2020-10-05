package google._271_Encode_and_Decode_Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/26/2020
 */
public final class CodecI implements Codec {
  private static final String SEP = "#";

  public String encode(List<String> strs) {
    if (strs == null) return null;
    final StringBuilder sb = new StringBuilder();
    for (final String str : strs) {
      sb.append(str.length()).append(SEP).append(str);
    }
    return sb.toString();
  }

  public List<String> decode(String s) {
    if (s == null) {
      return null;
    }
    final List<String> result = new ArrayList<>();
    for (int start = 0; start < s.length(); ) {
      final int sepIndex = s.indexOf(SEP, start),
          len = Integer.parseInt(s.substring(start, sepIndex));
      final int nextStart = sepIndex + 1 + len;
      result.add(s.substring(sepIndex + 1, nextStart));
      start = nextStart;
    }
    return result;
  }
}
