package _1251_1300._1268_Search_Suggestions_System._1279_Traffic_Light_Controlled_Intersection;

/**
 * @author jacka
 * @version 1.0 on 1/4/2020
 */
public final class SolutionI implements TrafficLight {
  private volatile int greenLightId = 1;
  private final Object lock = new Object();

  public void carArrived(int carId, int roadId, int direction, Runnable turnGreen, Runnable crossCar) {
    synchronized (lock) {
      if (greenLightId != roadId) {
        greenLightId = roadId;
        turnGreen.run();
      }
      crossCar.run();
    }
  }
}
