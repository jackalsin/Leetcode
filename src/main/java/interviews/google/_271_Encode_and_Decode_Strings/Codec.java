package interviews.google._271_Encode_and_Decode_Strings;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/26/2020
 */
public interface Codec {
  // Encodes a list of strings to a single string.
  String encode(List<String> strs);

  // Decodes a single string to a list of strings.
  List<String> decode(String s);
}
