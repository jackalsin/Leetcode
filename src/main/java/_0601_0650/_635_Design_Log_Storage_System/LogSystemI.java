package _0601_0650._635_Design_Log_Storage_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class LogSystemI implements Solution {
  private static final String YEAR = "Year",
      MONTH = "Month", DAY = "Day", HOUR = "Hour", MINUTE = "Minute", SECOND = "Second";
  private static final Map<String, Long> GRA_TO_BIAS = new HashMap<String, Long>() {{
    put(SECOND, 1L);
    put(MINUTE, 1_00L);
    put(HOUR, 1_00_00L);
    put(DAY, 1_00_00_00L);
    put(MONTH, 1_00_00_00_00L);
    put(YEAR, 1_00_00_00_00_00L);
  }};
  private final TreeMap<Long, Integer> logs = new TreeMap<>();

  public void put(int id, String timestamp) {
    final long key = getStartKey(timestamp, SECOND);
    logs.put(key, id);
  }

  public List<Integer> retrieve(String s, String e, String gra) {
    final long inclusiveStartKey = getStartKey(s, gra), exclusiveEndKey = getEndKey(e, gra);
//    System.out.println("inclusive = " + inclusiveStartKey + ", exclusive " + exclusiveEndKey + ", map = " + logs);
//    System.out.println("Found = " + logs.subMap(inclusiveStartKey, true, exclusiveEndKey, false));
    return new ArrayList<>(logs.subMap(inclusiveStartKey, true, exclusiveEndKey, false).values());
  }

  private long getEndKey(String key, final String gra) {
    final long endKey = getStartKey(key, gra), g = GRA_TO_BIAS.get(gra);
    return (endKey / g + 1) * g;
  }

  private static long getStartKey(final String timestamp, final String gra) {
    final String[] entries = timestamp.split(":");
    long res = 0;
    for (final String e : entries) {
      res = res * 100 + Integer.parseInt(e);
    }
    final long g = GRA_TO_BIAS.get(gra);
    return res / g * g;
  }
}
