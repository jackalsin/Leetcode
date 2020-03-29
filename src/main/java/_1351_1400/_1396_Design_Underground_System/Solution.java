package _1351_1400._1396_Design_Underground_System;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
public interface Solution {

  public void checkIn(int id, String stationName, int t);

  public void checkOut(int id, String stationName, int t);

  public double getAverageTime(String startStation, String endStation);
}
