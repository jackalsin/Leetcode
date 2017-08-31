package _251_300._271_Encode_and_Decode_Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/30/2017.
 */
public class Codec {
  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s: strs) {
      // 1/a
      sb.append(s.length()).append("/").append(s);
    }
    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List<String> result = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      int slashIndex = s.indexOf("/", i);
      int len = Integer.parseInt(s.substring(i, slashIndex));
      result.add(s.substring(slashIndex + 1, slashIndex + len + 1));
      i = slashIndex + len + 1;
    }
    return result;
  }
}
