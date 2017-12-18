package _501_550._535_Encode_and_Decode_TinyURL;

import java.util.HashMap;
import java.util.Map;

public final class Codec {
  private final Map<String, Integer> ltos;
  private final Map<Integer, String> stol;
  static int COUNTER;
  private static final String ELEMENTS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public Codec() {
    ltos = new HashMap<>();
    stol = new HashMap<>();
    COUNTER = 0;
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String shorturl = base10ToBase62(COUNTER);
    ltos.put(longUrl, COUNTER);
    stol.put(COUNTER, longUrl);
    COUNTER++;
    return "http://tiny.url/" + shorturl;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    final String uri = shortUrl.substring("http://tiny.url/".length());
    int count = base62ToBase10(uri);

    return stol.get(count);
  }

  private int base62ToBase10(String shortUrl) {
    int count = 0;
    for (char chr : shortUrl.toCharArray()) {
      count *= 62;
      count += convert(chr);
    }
    return count;
  }

  private int convert(char chr) {
    if (chr >= '0' && chr <= '9') {
      return chr - '0';
    } else if (chr >= 'a' && chr <= 'z') {
      return chr - 'a' + 10;
    } else {
      return chr - 'A' + 10 + 26;
    }
  }

  private String base10ToBase62(int count) {
    final StringBuilder sb = new StringBuilder();
    while (count != 0) {
      sb.insert(0, ELEMENTS.charAt(count % 62));
      count /= 62;
    }
    while (sb.length() != 6) {
      sb.insert(0, '0');
    }
    return sb.toString();
  }
}
