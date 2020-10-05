package _0601_0650._635_Design_Log_Storage_System;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public interface Solution {

  void put(int id, String timestamp);

  List<Integer> retrieve(String s, String e, String gra);
}
