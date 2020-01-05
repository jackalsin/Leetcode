package _1251_1300._1268_Search_Suggestions_System._1279_Traffic_Light_Controlled_Intersection;

/**
 * @author jacka
 * @version 1.0 on 1/4/2020
 */
public interface TrafficLight {
  void carArrived(
      int carId,           // ID of the car
      int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
      int direction,       // Direction of the car
      Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
      Runnable crossCar    // Use crossCar.run() to make car cross the intersection
  );
}
